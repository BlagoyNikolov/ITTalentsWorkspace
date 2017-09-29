package na_selo;

public class Bidon {

	private static final int MAX_CAPACITY = 100;
	private static final int MIN_CAPACITY = 0;
	private int currentPlum;
	
	Bidon(){
		this.currentPlum = MIN_CAPACITY;
	}
	
	public synchronized void add(int kg){
		while(this.currentPlum + kg > MAX_CAPACITY){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Nqma mqsto v bidona");
			}
		}
		this.currentPlum += kg;
		System.out.println("Dobavihme " + kg + " kg slivi");
		notifyAll();
	}
	
	public synchronized void get(int kg){
		while(this.currentPlum < kg){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Nqma slivi v bidona");
			}
		}
		this.currentPlum -= kg;
		System.out.println("Vzehme " + kg + " kg slivi");
		notifyAll();
	}
	
	
}
