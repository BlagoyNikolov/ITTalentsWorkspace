package scheduler;

public class DoHomework implements Task {
	@Override
	public void doWork(int time) {
		System.out.println("Homework done for time of " + time);
	}
}
