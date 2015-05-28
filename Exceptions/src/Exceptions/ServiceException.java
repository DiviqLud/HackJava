package Exceptions;

public class ServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8172495342332505708L;

	public ServiceException() {
		super();
	}

	public ServiceException(String s) {
		super(s);
	}

	public ServiceException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public ServiceException(Throwable throwable) {
		super(throwable);
	}
	
	public String getMessage() {
		String msg = "Our server is not available at the moment. We are working on the problem!";
		return msg;
	}
}
