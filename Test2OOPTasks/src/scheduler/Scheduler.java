package scheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
	private Queue<Task> tasks;
	
	public Scheduler() {
		this.tasks = new LinkedList<Task>();
	}
	
	public void addTask(Task t) {
		this.tasks.offer(t);
	}
	
	public void start() {
		while (true) {
			if (!tasks.isEmpty()) {
				tasks.poll().doWork(8);
			}
		}
	}
}
