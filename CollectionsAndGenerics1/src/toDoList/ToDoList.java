package toDoList;

import java.util.PriorityQueue;

public class ToDoList {
	private float totalTime;
	PriorityQueue<Task> pq = new PriorityQueue<Task>();
	
	public ToDoList(int time) {
		this.totalTime = time;
	}
	
	public void addTask (Task t) {
		pq.add(t);
	}
	
	public void markFinished(Task t) {
		t.setFinished(true);
		
	}
	
	public void markCancelled(Task t) {
		t.setCanceled(true);
		pq.remove(t);
	}
	
	public Task getTop () {
		return pq.peek();
	}
	
	public boolean canFinish() {
		return totalTimeNeeded() <= totalTime;
	}
	
	public float getRemainingTime() {
		return totalTime - totalTimeNeeded();
	}
	
	public float totalTimeNeeded() {
		float counter = 0;
		for (Task t : pq) {
			counter += t.getHours();
		}
		return counter;
	}
				
}
