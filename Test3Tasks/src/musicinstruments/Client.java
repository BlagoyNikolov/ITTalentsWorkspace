package musicinstruments;

public class Client extends Thread{
	private Shop s;
	
	public Client(Shop s) {
		this.s = s;
	}

	@Override
	public void run() {
		while(true){
			s.sell("Fender", 3);
		}
	}
}
