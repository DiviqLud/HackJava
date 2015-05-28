package subtitlesFixing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Path;

public class fixSubtitles {
	public static void fixEncoding(Path path) throws IOException {
		FileInputStream fis = new FileInputStream(path.toString());
		InputStreamReader isr = new InputStreamReader(fis, "Windows-1251");
		
		Reader in = new BufferedReader(isr);
		StringBuffer buffer = new StringBuffer();
		
		int c;
		
		while((c = in.read()) != -1) {
			buffer.append((char) c );
		}
		in.close();
		
		FileOutputStream fos = new FileOutputStream(path.toFile());
		Writer wr = new OutputStreamWriter(fos, "UTF8");
		wr.write(buffer.toString());
		wr.close();
		
	}
}
