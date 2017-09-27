package nataport;

public class Distributor extends Thread {

	//producer na storage
	private Storage storage;
	
	public Distributor ( Storage storage){
		 this.storage= storage;
	}
	
	@Override
	public void run() {
		while (true){
			
		}
	}
}
