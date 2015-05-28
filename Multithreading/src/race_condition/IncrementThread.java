package race_condition;

public class IncrementThread implements Runnable {
	private String threadName;
	Counter counter;

	public IncrementThread(String name, Counter c) {
		threadName = name;
		counter = c;
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 0; i < 20; i++) {
				counter.incremented();
				System.out.println("Thread: "
						+ Thread.currentThread().getName() + " -> "
						+ counter.getCounter());
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " interrupted.");
		}

		System.out.println("Thread " + threadName + " exiting.");
	}

}
