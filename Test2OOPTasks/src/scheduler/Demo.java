package scheduler;

public class Demo {
	public static void main(String[] args) {
		Scheduler s = new Scheduler();
		s.addTask(new DoHomework());
		s.addTask(new BuildHouse());
		s.addTask(new Task() {
			@Override
			public void doWork(int time) {
				System.out.println("Write code for time of " + time);
			}
		});
		s.addTask((int time) -> System.out.println("Write lambdafor time of " + time));
		s.start();
	}
}
