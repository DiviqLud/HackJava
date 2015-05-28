package symbolicLinks;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateSymbolicLinks {
	public static void createSymlinks() {
		Path newLink = FileSystems.getDefault().getPath(
				"/home/galin/JavaWorkspace/SymbolicLinksTest/Bla/symlink2.txt");
		Path target = FileSystems.getDefault().getPath(
				"/home/galin/JavaWorkspace/Exceptions/wtf123.txt");
		try {
			Files.createSymbolicLink(newLink, target);
		} catch (IOException x) {
			System.err.println(x);
		} catch (UnsupportedOperationException x) {
			System.err.println(x);
		}
	}
}
