package week1.Calculator;

import java.util.Stack;

public class Calculator {

	public static int opWeight(char op) {
		if (op == '*' || op == '/') {
			return 2;
		}
		if (op == '+' || op == '-') {
			return 1;
		}
		return -1;
	}

	public static boolean isDigit(char a) {
		return a >= '0' && a <= '9';
	}

	public static boolean isOperation(char a) {
		return a == '*' || a == '/' || a == '+' || a == '-';
	}

	public static StringBuilder translateExpression(String expr) {
		Stack<Character> operations = new Stack<Character>();
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i != expr.length()) {
			if (isDigit(expr.charAt(i))) {
				result.append(expr.charAt(i));
				i++;
			}

			if (expr.charAt(i) == '(') {
				operations.push(expr.charAt(i));
				i++;
			}

			if (isOperation(expr.charAt(i))) {
				if (!operations.isEmpty()) {
					char op = operations.pop();
					if (op == '(') {
						operations.push(op);
						operations.push(expr.charAt(i));
						i++;
					} else {
						if (opWeight(op) <= opWeight(expr.charAt(i))) {
							if (isDigit(expr.charAt(i + 1))
									&& i + 1 != expr.length()) {
								result.append(expr.charAt(i + 1));
								result.append(expr.charAt(i));
								operations.push(op);
								i += 2;
							} else {
								operations.push(op);
								operations.push(expr.charAt(i));
								i++;
							}
						}
					}
				} else {
					operations.push(expr.charAt(i));
					i++;
				}
			}

			if (expr.charAt(i) == ')') {
				char op = operations.pop();
				while (op != '(') {
					result.append(op);
					op = operations.pop();
				}
				i++;
			}

		}
		while (!operations.isEmpty()) {
			char c = operations.pop();
			result.append(c);
		}
		return result;
	}

	public static int evaluate(StringBuilder expr) {
		Stack<String> st = new Stack<String>();
		int i = 0;
		while (i != expr.length()) {
			if (isDigit(expr.charAt(i))) {
				st.push(Character.toString(expr.charAt(i)));
				i++;
			} else {
				int op1 = Integer.parseInt(st.pop());
				int op2 = Integer.parseInt(st.pop());

				switch (Character.toString(expr.charAt(i))) {
				case "+": {
					int sum = op1 + op2;
					st.push(Integer.toString(sum));
				}
					break;
				case "-": {
					int sum = op1 - op2;
					st.push(Integer.toString(sum));
				}
					break;
				case "*": {
					int sum = op1 * op2;
					st.push(Integer.toString(sum));
				}
					break;
				case "/": {
					int sum = op1 / op2;
					st.push(Integer.toString(sum));
				}
					break;
				}
				i++;
			}
		}
		return Integer.parseInt(st.pop());
	}

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		StringBuilder v = new StringBuilder();
		StringBuilder g = new StringBuilder();
		s = translateExpression("2+3*(4+3)");
		System.out.println(s);
		v = translateExpression("(4+3/2+7*(4+3)/7)");
		System.out.println(v);
		g = translateExpression("(2+3+(4+3*4+5)/2)");
		System.out.println(g);
		System.out.println(evaluate(s));
	}
}
