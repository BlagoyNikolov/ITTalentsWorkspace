package musicinstruments;

public class Client extends Thread{
	private Shop s;
	private String name;
	private int quantity;
	
	public Client(Shop s, String name, int quantity) {
		this.s = s;
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public void run() {
		while(true){
			this.s.sell(this.name, this.quantity);
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
