package nataport;

import java.util.Queue;

public class Kran extends Thread {
	// producer na dock
	private int id;
	//private Dock dock;
	private Pristanishte pristan;

	public Kran() {
		
	}

//	@Override
//	public void run() {
//		while (true) {
//			dock.obikalqi();
//		}
//		super.run();
//	}
//	
	 @Override
	public void run() {
		while(true){
			for(int i = 0; i < pristan.getDocks().size(); i++){
				Queue<Dock> dock = pristan.getDocks().get(i);
				Dock ship;
				synchronized (dock) {
					if(dock.isEmpty()){
						try {
							wait();
						} catch (InterruptedException e) {
						System.out.println("ops");
						}
					}
					ship = dock.poll();	
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
//				int amount = new Random().nextInt(31)+10;
//				car.setAmount(amount);
//				car.setKolonka(i+1);
//				System.out.println("Kolata zaredi " + amount + " litra " + fuelType.toString() );
//				station.alignToPay(car);
			}
		}
	}
}
