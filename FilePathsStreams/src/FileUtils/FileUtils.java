package FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {

	private static FileUtils instance = null;

	private FileUtils() {

	}

	public static FileUtils getInstance() {
		if (instance == null) {
			instance = new FileUtils();
		}
		return instance;
	}

	public String readFrom(File file) throws IOException {
		FileReader f = new FileReader(file);
		BufferedReader br = new BufferedReader(f);

		StringBuilder result = new StringBuilder();
		String line = br.readLine();

		while (line != null) {
			result.append(line.toString() + "\n");
			line = br.readLine();
		}
		br.close();
		return result.toString();
	}

	public String readFrom(Path path) throws IOException {
		File file = path.toFile();
		return readFrom(file);

	}

	public void writeIn(String text) throws IOException {
		File file = new File("abc.txt");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(text);
		bw.close();
	}

}
