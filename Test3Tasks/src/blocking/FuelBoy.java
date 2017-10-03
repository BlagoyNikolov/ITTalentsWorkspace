package blocking;

public class FuelBoy extends Thread{

	private GasStation gs;
	
	public FuelBoy(String name, GasStation gs) {
		setName(name);
		this.gs = gs;
	}
	
	@Override
	public void run() {
	
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
			if(isInterrupted()){
				//do something else
			}
			else{
				gs.removeCar();//load the car without paying for now
			}
		}
	}
	
	
}