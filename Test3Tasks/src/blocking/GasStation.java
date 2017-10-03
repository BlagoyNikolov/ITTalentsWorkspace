package blocking;

import java.util.ArrayList;
import java.util.Random;

public class GasStation {

	private String name;
	private FuelBoy rab1;
	private FuelBoy rab2;
	
	private ArrayList<Kolonka> kolonki;
	
	public GasStation(String name) throws InvalidGasStationException {
		if(name == null || name.isEmpty()){
			throw new InvalidGasStationException("Sori brat, nqma ime");
		}
		kolonki = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			kolonki.add(new Kolonka());
		}
		rab1 = new FuelBoy("FuelBoy 1", this);
		rab2 = new FuelBoy("FuelBoy 2", this);
		rab1.start();
		rab2.start();
	}

	public void addCar(Car car) {
		int rand = new Random().nextInt(5);
		synchronized (kolonki) {
			Kolonka k = kolonki.get(rand);
			synchronized (k) {
				k.addCar(car);
				System.out.println(Thread.currentThread().getName() + " Added car in kolonka " + rand);
				kolonki.notifyAll();	
			}
		}
	}
	
	void removeCar(){
		while(allEmpty()){
			synchronized (kolonki) {
				try {
					System.out.println(Thread.currentThread().getName() + " No cars in any kolonka, i wait");
					kolonki.wait();
					System.out.println(Thread.currentThread().getName() + "Chuhme, che ima kola, dai da vidim");
				} catch (InterruptedException e) {
					System.out.println("opala");
				}
			}
		}
		for(int i = 0; i < kolonki.size(); i++){
			Kolonka k = kolonki.get(i);
			if(!k.isEmpty()){
				synchronized (k) {
					Car removed = k.removeCar();
					System.out.println(Thread.currentThread().getName() + " Removed car from kolonka " + i);
					k.notifyAll();
				}
			}
		}
	}
	
	private boolean allEmpty(){
		for(Kolonka k : kolonki){
			if(!k.isEmpty()){
				return false;
			}
		}
		return true;
	}
}
