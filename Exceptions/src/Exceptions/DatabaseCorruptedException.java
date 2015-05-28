package Exceptions;

public class DatabaseCorruptedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -445503031347068323L;

	public DatabaseCorruptedException() {
		super();
	}

	public DatabaseCorruptedException(String s) {
		super(s);
	}

	public DatabaseCorruptedException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public DatabaseCorruptedException(Throwable throwable) {
		super(throwable);
	}

}
