package crossroads;

public class Traveller extends Thread {
	private Cross cross;

	public Traveller(Cross cross) {
		this.cross = cross;
	}
	
	@Override
	public void run() {
		while(true) {
			this.cross.enter(this);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
