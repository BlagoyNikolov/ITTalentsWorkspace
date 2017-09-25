package threads.naselo;

public class Baba extends Thread {
	private Gurne g;

	public Baba(Gurne g) {
		this.g = g;
	}
	
	@Override
	public void run() {
		while(true) {
			this.g.sipiBob();
		}
	}
}
