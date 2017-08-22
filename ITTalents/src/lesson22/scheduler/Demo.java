package lesson22.scheduler;

import java.util.HashSet;

public class Demo {

	public static void main(String[] args) {
		
		Scheduler s = new Scheduler();
		s.addTask(new DoHomework());
		s.addTask(new BuildHouse());
		s.addTask(new Task() {
			
			@Override
			public void complete(int time ) {
				System.out.println("Vodka drunk in " + time/2);
			}
		});
		s.addTask( time -> System.out.println("Lambda done in " + time)   );
		s.addTask( time -> System.out.println("Task 1 done in " + time)   );
		s.addTask( time -> System.out.println("Task 2 done in " + time)   );
		s.addTask( time -> System.out.println("Task 3 done in " + time)   );
		s.addTask( time -> System.out.println("Task 4 done in " + time)   );
		s.start();
		
		
		
	}
}
