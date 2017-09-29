package na_selo;

public abstract class Person extends Thread{

	protected String name;
	protected int time;
	
	public Person(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		while (true){
			try {
				sleep(time * 1000);
			} catch (InterruptedException e) {
				System.out.println("nqmada se spi");
			}
			work();
		}
	}
	
	abstract void work();
}
