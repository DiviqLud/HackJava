package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Test;

import subtitlesFixing.fixSubtitles;

public class SubtitlesEncoding {

	@Test
	public void test() throws IOException {
		Path path = FileSystems.getDefault().getPath("/home/galin", "lost.s04e11.hdtv.xvid-2hd.srt");
		fixSubtitles.fixEncoding(path);
		InputStreamReader r = new InputStreamReader(new FileInputStream(path.toFile()));
		assertEquals(r.getEncoding(), "UTF8");
	}

}
