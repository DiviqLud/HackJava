package blockingQueue;


public class TestBlockingQueue {
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue queue = new BlockingQueue();
		queue.addElement(5);
		
		Thread A = new Thread(new CustomThread(queue));
		Thread B = new Thread(new CustomThread1(queue));
		
		A.start();
		B.start();
		
		A.join();
		B.join();
		
		
	}
	
}
