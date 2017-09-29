package rakia;

public class ZaharenZavod {
	private static final int MAX_CAPACITY = 300;
	private int capacity;
	
	public synchronized void addToZzgo(int amount) {
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
	
	public synchronized void removeFromZzgo(int amount) {
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
		return ("Zaharna trustika v zavoda: " + this.capacity + "\n");
	}
}
