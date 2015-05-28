package fileCompression;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextFileCompression {
	// Map<Word, Number> <"buffalo", 0>
	private static Map<String, Map<String, Integer>> infoForFile = new HashMap<String, Map<String, Integer>>();
	private static int number = 0;
	private static StringBuilder result;
	private static StringBuilder word;

	public static Reader returnReader(Path filePath)
			throws FileNotFoundException {
		Reader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath.toFile())));

		return in;
	}
	
	public static void writeInFile(Path filePath, String result)
			throws IOException {
		FileWriter fw = new FileWriter(filePath.toFile() + ".compr");
		Writer w = new BufferedWriter(fw);
		w.write(result);
		w.close();
	}

	public static void compress(Path filePath) throws IOException {
		Reader in = returnReader(filePath);

		Map<String, Integer> compressedWord = new HashMap<String, Integer>();
		word = new StringBuilder();
		result = new StringBuilder();

		int c;

		while ((c = in.read()) != -1) {
			char token = (char) c;
			if (token == ' ' || token == '.') {
				if (!compressedWord.containsKey(word.toString())) {
					compressedWord.put(word.toString(), number);
					number += 1;
				}
				result.append("~" + compressedWord.get(word.toString()) + " ");
				word = new StringBuilder();
			} else {
				word.append(token);
			}

		}
		in.close();

		writeInFile(filePath, result.toString());
		infoForFile.put(filePath.toFile() + ".compr", compressedWord);
	}

	public static void decompress(Path filePath) throws IOException {
		
		Map<String, Integer> compressedWord1 = infoForFile.get(filePath + ".compr");

		Path path = FileSystems.getDefault().getPath("/home/galin/JavaWorkspace/SymbolicLinksTest", "text1.compr");
		Reader out = returnReader(path);
		
		result = new StringBuilder();
		word = new StringBuilder();

		int c;

		while ((c = out.read()) != -1) {
			char token = (char) c;
			if (token == ' ' || token == '.') {
				int index = Character.getNumericValue(word.charAt(word.length() - 1));
				if (compressedWord1.containsValue(index)) {
					for (String word : compressedWord1.keySet()) {
						if (compressedWord1.get(word) == index) {
							result.append(word + " ");
						}
					}
					word = new StringBuilder();
				} else {
					throw new RuntimeException("I don't know what to do!");
				}
			} else {
				word.append(token);
			}
		}

		writeInFile(filePath, result.toString());
		
	}

	public static void main(String[] args) throws IOException {
		Path pathToCompress = FileSystems.getDefault().getPath(
				"/home/galin/JavaWorkspace/SymbolicLinksTest", "text1");
		
		compress(pathToCompress);
		decompress(pathToCompress);
	}

}
