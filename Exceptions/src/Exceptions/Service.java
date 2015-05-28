package Exceptions;

public class Service {
	public static void main(String[] args) {
		try {
			useService(false);
		} catch (ServiceException se) {
			System.out.println(se.getMessage());
		}
	}
	
	public static void useService(boolean active) throws ServiceException{
		if (!active) {
			throw new ServiceException();
		}
		
	}
}
