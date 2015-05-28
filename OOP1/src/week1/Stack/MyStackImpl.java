package week1.Stack;

import java.util.ArrayList;

public class MyStackImpl {
	private ArrayList<Integer> stack = new ArrayList<Integer>();	
	
	public MyStackImpl() {
	}

	public void push(int element) {
		stack.add(element);
	}
	
	public int peekIndex() {
		return stack.size() - 1;
	}
	
	public void pop() {
		
		stack.remove(peekIndex());
	}

	public int length() {
		return stack.size();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void print() {
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i)+ " ");
		}
	}
//	
//	public static MyStack factoryMethod() {
//		MyStack st = new MyStack() {
//			
//		}
//	}
}
