package toDoList;

public class Task implements Comparable<Task> {
	
	
	private float hours;
	private int priority;
	private boolean isFinished;
	private boolean isCanceled;

	public Task() {
		hours = 1;
		priority = 1;
		isFinished = false;
		isCanceled = false;
	} 
	
	public Task(float hours) {
		this.hours = hours;
	}
	
	public Task (int priority) {
		this.priority = priority;
		
	}
	
	public Task(int hours, int priority, boolean isFinished, boolean isCanceled) {
		super();
		this.hours = hours;
		this.priority = priority;
		this.isFinished = isFinished;
		this.isCanceled = isCanceled;
	}


	public float getHours() {
		return hours;
	}

	public int getPriority() {
		return priority;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	@Override
	public int compareTo(Task task) {
		if (this.priority < task.priority)
			return 1;
		else if (this.priority > task.priority){
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Task [hours=" + hours + ", priority=" + priority
				+ ", isFinished=" + isFinished + ", isCanceled=" + isCanceled
				+ "]";
	}
	
	
}
