package musicinstruments;

public class Supplier extends Thread{
	private Shop s;

	public Supplier(Shop s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		while(true) {
			this.s.buy();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
