package blockingQueue;

public class CustomThread implements Runnable{

	private BlockingQueue queue;
	
	public CustomThread(BlockingQueue que) {
		queue = que;
	}
	
	@Override
	public void run() {
		try {
			while (true)
				queue.removeElement();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
