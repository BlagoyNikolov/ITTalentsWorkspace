package scheduler;

public class BuildHouse implements Task {
	@Override
	public void doWork(int time) {
		System.out.println("House built for time of " + time);
	}
}
