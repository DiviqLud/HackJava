package immutableList;

public class ImmutableException extends Exception{

	private static final long serialVersionUID = 1L;

	public ImmutableException() {
		super();
	}

	public ImmutableException(String s) {
		super(s);
	}

	public ImmutableException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public ImmutableException(Throwable throwable) {
		super(throwable);
	}
	
	public String getMessage() {
		String msg = "The list is immutable!";
		return msg;
	}
}
