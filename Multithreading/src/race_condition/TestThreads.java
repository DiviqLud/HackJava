package race_condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreads {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		
		ExecutorService manager = Executors.newFixedThreadPool(4);
		
		manager.execute(new IncrementThread("A", counter));
		manager.execute(new IncrementThread("B", counter));
		manager.execute(new IncrementThread("C", counter));
		
		manager.shutdown();
	}
}
