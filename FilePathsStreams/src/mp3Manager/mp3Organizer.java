package mp3Manager;

import java.io.File;
import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.id3.ID3v1;
import org.farng.mp3.TagException;

public class mp3Organizer {
	public static void main(String[] args) throws IOException, TagException {
		File sourceFile = new File("Theme - Fat Albert.mp3");
		MP3File mp3file = new MP3File(sourceFile);
		ID3v1 a = mp3file.getID3v1Tag();
	}
}
