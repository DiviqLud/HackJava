package blockingQueue;

public class CustomThread1 implements Runnable{

	private BlockingQueue queue;
	
	public CustomThread1(BlockingQueue que) {
		queue = que;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0 ; i < 10; i++) {
				Thread.sleep(200);
				queue.addElement(i);			
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
