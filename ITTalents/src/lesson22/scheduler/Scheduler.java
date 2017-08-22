package lesson22.scheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {

	private Queue<Task> tasks;
	
	public Scheduler() {
		this.tasks = new LinkedList<>();
	}
	
	void addTask(Task t){
		this.tasks.offer(t);
	}
	
	void start(){
		while(true){
			if(!tasks.isEmpty()){
				tasks.poll().complete(5);
			}
		}
	}
}
