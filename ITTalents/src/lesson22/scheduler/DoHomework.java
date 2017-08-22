package lesson22.scheduler;

public class DoHomework implements Task{

	@Override
	public void complete(int time) {
		System.out.println("Homework done in " + time);
	}

}
