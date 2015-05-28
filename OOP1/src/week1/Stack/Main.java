package week1.Stack;

public class Main {
	public static void main(String[] args) {
		MyStackImpl st = new MyStackImpl();
		st.push(55);
		st.push(65);
		st.print();
		st.pop();
		st.print();
	}
	
}
