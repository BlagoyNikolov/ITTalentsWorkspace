package carfactory;

public abstract class Component implements Runnable {
	private int time;
	private String name;

	public Component(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(this.time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + " is ready for " + this.time + " seconds");
	}
}
