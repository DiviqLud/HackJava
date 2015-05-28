package Exceptions;


public class UncheckedException {
	public static void main(String[] args) {
		boo();
	}
	
	public static void boo() {
		try {
			foo();
		}
		catch (RuntimeException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void foo(){
		try {
			System.out.println(5 / 0);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}
}
