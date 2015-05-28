package race_condition;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


public class Counter {
	private AtomicInteger counter;
	boolean increment = false;
	private Lock lock = new Lock();
	
	public Counter() {
		counter = new AtomicInteger(0);
	}
	
	public void incremented() throws InterruptedException {
		lock.lock();
		counter.getAndIncrement();
		lock.unlock();
		
	}

	public int getCounter() {
		return counter.get();
	}

	public void setCounter(int i) {
		counter.set(i);
	}
}
