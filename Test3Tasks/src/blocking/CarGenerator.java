package blocking;

public class CarGenerator extends Thread{

	private GasStation gs;
	
	public CarGenerator(GasStation gs) {
		this.gs = gs;
		setName("CarGenerator");
	}
	
	@Override
	public void run() {
	
		while(true){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
			for(int i = 0; i < 5; i++){
				Car car = new Car();
				gs.addCar(car);
			}
		}
	}
	
	
}
