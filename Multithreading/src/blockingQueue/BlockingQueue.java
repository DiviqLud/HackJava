package blockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	private Queue<Integer> queue;
	private Object mutex = new Object();

	public BlockingQueue() {
		queue = new LinkedList<Integer>();
	}

	public void removeElement() throws InterruptedException {
		synchronized (mutex) {
			if (queue.isEmpty()) {
				System.out.println("Thread " + Thread.currentThread().getName()
						+ " is waiting to be added element");
				mutex.wait();
			} else {
				Integer x = queue.poll();
				System.out.println("Thread " + Thread.currentThread().getName()
						+ " successfully deleted element: " + x);
			}
		}
	}

	public void addElement(Integer x) throws InterruptedException {
		synchronized(mutex) {
			queue.offer(x);
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " successfully added element: " + x);
			mutex.notifyAll();
		}
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
