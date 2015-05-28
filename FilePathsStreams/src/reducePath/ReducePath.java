package reducePath;

import java.nio.file.Path;

public class ReducePath {
	public static Path reducePath(Path path) {
		return path.normalize();
	}
}
