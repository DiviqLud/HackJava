package week1.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class LLImpl implements LinkedList {
	Node head;
	Node tail;
	int size;

	public LLImpl() {
		head = tail = null;
		size = 0;
	}

	public void add(int elem) {
		if (size == 0) {
			head = new Node(null, null, elem);
			tail = head;
			size++;
		} else if (size == 1) {
			Node newNode = new Node(tail, null, elem);
			head.setNext(newNode);
			tail = newNode;
			size++;
		} else {
			Node newNode = new Node(tail, null, elem);
			tail.setNext(newNode);
			tail = newNode;
			size++;
		}

	}

	public void remove() {
		Node nodeToDel = tail.getPrev();
		tail.setPrev(null);
		tail = nodeToDel;
	}
		 

	public int size() {
		return size;
	}

	public int get(int elementIndex) {
		Node copyHead = head;
		if (size < elementIndex) {
			return -1;
		}
		else if (size == elementIndex) {
			return tail.getInfo();
		}
		else {
			int i = 1;
			while (i != elementIndex) {
				copyHead = copyHead.getNext();
				i++;
			}
			return copyHead.getInfo();
		}
	}

	public int getHead() {
		return head.getInfo();
	}

	public int getTail() {
		return tail.getInfo();
	}

	public void print() {
		Node copyHead = head;
		while (copyHead != null) {
			System.out.print(copyHead.getInfo() + " ");
			copyHead = copyHead.getNext();
		}
	}
}
