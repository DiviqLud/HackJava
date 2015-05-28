package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wcCommand.WordCount;
import wcCommand.WordCountResult;

public class WCCommandTest {

	@Before
	public void setUp() throws Exception {
		PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
		writer.println("Az sum galin.");
		writer.println("Ico e lud hah.");
		writer.close();
	}

	@After
	public void tearDown() throws Exception {
		Path path = FileSystems.getDefault().getPath("/home/galin/JavaWorkspace/FilePathsStreams", "test.txt");
		Files.deleteIfExists(path);
	}

	@Test
	public void test() throws IOException {
		WordCountResult result = WordCount.wordCount(new File("test.txt"));
		assertEquals(result.getCharacters(), 20);
		assertEquals(result.getLines(), 2);
		assertEquals(result.getWords(), 7);
		
	}

}
