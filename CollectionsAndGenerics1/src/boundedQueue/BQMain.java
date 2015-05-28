package boundedQueue;

public class BQMain {
	public static void main(String[] args) {
		BoundedQueue boundedQueue = new BoundedQueue(3);
		boundedQueue.offer(1);
		boundedQueue.offer(2);
		boundedQueue.offer(3); // 1, 2, 3
		boundedQueue.offer(4); // 2, 3, 4
		boundedQueue.offer(5); // 3, 4, 5
		boundedQueue.printElements(); //3,4,5
	}
}
