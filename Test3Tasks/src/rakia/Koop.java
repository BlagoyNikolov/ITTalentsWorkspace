package rakia;

public class Koop {
	private static final int RAKIA_MAX_CAPACITY = 150;
	private static final int KOMPOT_MAX_CAPACITY = 200;
	private int rakiaCapacity;
	private int kompotCapacity;
	
	public synchronized void addRakiaToKoop(int amount) {
		while (this.rakiaCapacity >= RAKIA_MAX_CAPACITY) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.rakiaCapacity += amount;
		notifyAll();
	}
	
	public synchronized void removeRakiaFromKoop(int amount) {
		while (this.rakiaCapacity <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.rakiaCapacity -= amount;
		notifyAll();
	}
	
	public synchronized void addKompotToKoop(int amount) {
		while (this.kompotCapacity >= KOMPOT_MAX_CAPACITY) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.kompotCapacity += amount;
		notifyAll();
	}
	
	public synchronized void removeKompotFromKoop(int amount) {
		while (this.kompotCapacity <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.kompotCapacity -= amount;
		notifyAll();
	}
	
	public String printAvailability() {
		return ("Rakia v magazina: " + this.rakiaCapacity + "; Kompoti v magazina: " + this.kompotCapacity + "\n");
	}
}
