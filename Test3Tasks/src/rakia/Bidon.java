package rakia;

public class Bidon {
	private static final int MAX_CAPACITY = 50;
	private int capacity;
	
	public synchronized void addToBidona(int amount) {
		while (this.capacity >= MAX_CAPACITY) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.capacity += amount;
		notifyAll();
	}
	
	public synchronized void removeFromBidona(int amount) {
		while (this.capacity <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.capacity -= amount;
		notifyAll();
	}

	public String printAvailability() {
		return ("Grozde v bidona: " + this.capacity + "\n");
	}
}
