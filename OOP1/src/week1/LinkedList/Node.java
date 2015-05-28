package week1.LinkedList;

public class Node {
		Node next;
		Node prev;
		int info;
		
		public Node() {
			next = null;
			prev = null;
			info = 0;
		}
		
		public Node (Node prev, Node next, int info) {
			this.next = next;
			this.prev = prev;
			this.info = info;
		}
		
		public Node getNext() {
			return next;
		}
		public Node getPrev() {
			return prev;
		}
		public int getInfo() {
			return info;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public void setInfo(int info) {
			this.info = info;
		}
		
		

}
