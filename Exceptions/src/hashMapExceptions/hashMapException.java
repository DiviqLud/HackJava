package hashMapExceptions;

public class hashMapException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public hashMapException() {
		super();
	}
	
	public hashMapException(String s) {
		super(s);
	}
	
	public hashMapException(String s, Throwable t) {
		super(s, t);
	}
	
	public hashMapException(Throwable t) {
		super(t);
	}
	
	public String getMessage() {
		String result = "Can't put null as a key! Sorry!";
		return result;
	}
}
