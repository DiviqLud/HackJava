package wcCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WordCount {
	private static int characterCounter = 0;
	private static int wordCounter = 0;
	private static int lineCounter = 0;

	public static WordCountResult wordCount(Path path) throws IOException {
		WordCountResult result;

		File file = path.toFile();

		FileReader fileRead = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileRead);

		int currentChar = 0;

		while ((currentChar = buffer.read()) != -1) {
			char token = (char) currentChar;
			if (token == ' ') {
				wordCounter += 1;
			} else if (token == '\n') {
				lineCounter += 1;
			} else {
				characterCounter += 1;
			}
		}
		buffer.close();
		result = new WordCountResult(wordCounter, lineCounter, characterCounter);
		return result;
	}
	
	public static WordCountResult wordCount(File file) throws IOException {
		WordCountResult result;

		FileReader fileRead = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileRead);

		int currentChar = 0;

		while ((currentChar = buffer.read()) != -1) {
			char token = (char) currentChar;
			if (token == ' ' || token == '.') {
				wordCounter += 1;
			} else if (token == '\n') {
				lineCounter += 1;
			} else {
				characterCounter += 1;
			}
		}
		result = new WordCountResult(wordCounter, lineCounter, characterCounter);
		return result;
	}
}
