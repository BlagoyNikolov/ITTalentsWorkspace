package lesson22.scheduler;

public class BuildHouse implements Task {

	@Override
	public void complete(int time) {
		System.out.println("House completed in " + time);
	}

}
