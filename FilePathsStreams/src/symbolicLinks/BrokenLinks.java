package symbolicLinks;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrokenLinks {

	public static void findBadLinks(Path path) throws IOException {
		File[] files = new File(path.toString()).listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				findBadLinks(file.toPath());
			} else {
				if (Files.isSymbolicLink(file.toPath())) {
					if (!Files.exists(Files.readSymbolicLink(file.toPath()))) {
						System.out.println("Symbolic Link: " + file.getName());
					}
				}
			}
		}
	}

	public static void main(String... args) throws IOException {
		Path path = FileSystems.getDefault().getPath(
				"/home/galin/JavaWorkspace");
		CreateSymbolicLinks.createSymlinks();
		findBadLinks(path);
	}
}
