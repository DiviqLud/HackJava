package toDoList;

public class DoListMain {
	
	public static void main(String[] args) {
		ToDoList todo = new ToDoList(12);
		todo.addTask(new Task(10)); //maximum priority!
		todo.addTask(new Task()); //default priority, smaller than 10
		todo.addTask(new Task(1.5f));  //default priority, smaller than 10
		todo.addTask(new Task()); //straight 8 hours, of course!
	
		if (todo.canFinish()){
		    System.out.println("Woohoo!");
		} else {
		    System.out.println("I am ...screwed :(");
		}
	
		System.out.println(todo.getTop()); //StudyForAlgebraTask
		System.out.println(todo.totalTimeNeeded()); //sum of the time needed for every task added in todo list
	}
	
	
}
