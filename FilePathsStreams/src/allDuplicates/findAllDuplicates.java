package allDuplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAllDuplicates {
	private static final long MAX_SIZE = 512000;
	private static Map<Long, List<Path>> groups = new HashMap<Long, List<Path>>();
	private static List<Path> listOfPaths = new ArrayList<Path>();
	
	public static void putKey(Path path, List<Path> listOfPaths, File file) throws IOException {
		byte[] bytes = Files.readAllBytes(path);
		long hashCode = Arrays.hashCode(bytes);
		if (!groups.containsKey(hashCode)) {
			listOfPaths = new ArrayList<Path>();
			listOfPaths.add(file.toPath());
			groups.put(hashCode, listOfPaths);
		}else {
			groups.get(hashCode).add(file.toPath());
			groups.put(hashCode, groups.get(hashCode));
		}
	}
	
	public static Map<Long, List<Path>> findAllDuplicatess(String path)
			throws IOException {
		File[] files = new File(path.toString()).listFiles();

		for (File file : files) {
			if (file.isFile() && file.length() < MAX_SIZE) {
				if (Files.isSymbolicLink(file.toPath())) {
					Path symlink = Files.readSymbolicLink(file.toPath());
					if (Files.exists(symlink)) {
						// Import info in MAP
						putKey(symlink, listOfPaths, file);
					} else {
						continue;
					}
				}
				if (!Files.isRegularFile(file.toPath())) {
					continue;
				}
				putKey(file.toPath(), listOfPaths, file);
			} if (file.isDirectory()) {
				findAllDuplicatess(file.getAbsolutePath());
			}
		}
		return groups;
	}

	public static void main(String[] args) throws IOException {
		Path path = FileSystems.getDefault().getPath("/home/galin/JavaWorkspace/testData");
		
		Map<Long, List<Path>> result = findAllDuplicatess(path.toString());
		
		char c = 'A';
		
		for (Long hash : result.keySet()) {
			System.out.print("Group " + c + ": \n");
			for (int i = 0 ; i < result.get(hash).size(); i++) {
				System.out.println("File: " + result.get(hash).get(i));
			}
			c += 1;
			System.out.println();
		}
		
	}
}
