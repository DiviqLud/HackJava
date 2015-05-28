package week1.LinkedList;

import week1.Stack.MyStack;

public class Factory {
	public static MyStack createStack() {
		MyStack st = new MyStack() {

			LLImpl l = new LLImpl();

			@Override
			public void push(int element) {
				l.add(element);
			}

			@Override
			public void pop() {
				l.remove();
			}

			@Override
			public int peek() {
				return l.get(l.size() - 1);
			}

			@Override
			public int length() {
				return l.size();
			}

			@Override
			public boolean isEmpty() {
				return l.size() == 0;
			}

			@Override
			public void print() {
				l.print();

			}

		};

		return st;
	}
}
