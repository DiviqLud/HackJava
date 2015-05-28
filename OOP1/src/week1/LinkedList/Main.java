package week1.LinkedList;

public class Main {
	public static void main(String[] args) {
		LLImpl l = new LLImpl();
		l.add(123);
		l.add(54);
		l.add(764);
		l.add(432);
		l.add(5436);
		System.out.println(l.get(2));
		l.print();
		
	}
}
