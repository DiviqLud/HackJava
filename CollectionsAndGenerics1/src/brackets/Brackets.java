package brackets;

public class Brackets {
	public static void main(String[] args) {
		System.out.println(BracketsCorrection("()()())("));
	}
	
	public static boolean BracketsCorrection (String expr) {
		int counter = 0;
		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(') {
				counter++;				
			}
			if (expr.charAt(i) == ')') {
				counter--;
			}
			if (counter < 0) {
				return false;
			}
		}
		return counter == 0;
	}
}
