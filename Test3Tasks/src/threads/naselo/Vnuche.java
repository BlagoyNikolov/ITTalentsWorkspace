package threads.naselo;

public class Vnuche extends Thread {
	private Gurne g;

	public Vnuche(Gurne g) {
		this.g = g;
	}
	
	@Override
	public void run() {
		while(true) {
			this.g.removeBob(5);
		}
	}
}