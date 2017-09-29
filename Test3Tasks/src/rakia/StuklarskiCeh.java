package rakia;

public class StuklarskiCeh {
	private static final int BOTTLESS_MAX_CAPACITY = 400;
	private static final int BURKANI_MAX_CAPACITY = 250;
	private int bottlesCapacity;
	private int burkaniCapacity;
	
	public synchronized void addButilkiToStuklarskiCeh(int bottleAmount) {
		if (this.bottlesCapacity >= BOTTLESS_MAX_CAPACITY) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.bottlesCapacity += bottleAmount;
		notifyAll();
	}
	
	public synchronized void addBurkaniToStuklarskiCeh(int burkaniAmount) {
		if (this.burkaniCapacity >= BURKANI_MAX_CAPACITY) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.burkaniCapacity += burkaniAmount;
		notifyAll();
	}
	
	public synchronized void removeButilkiFromStuklarskiCeh(int bottleAmount) {
		if (this.bottlesCapacity <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.bottlesCapacity -= bottleAmount;
		notifyAll();
	}
	
	public synchronized void removeBurkaniFromStuklarskiCeh(int burkaniAmount) {
		if (this.burkaniCapacity <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.burkaniCapacity -= burkaniAmount;
		notifyAll();
	}
	
	public String printAvailability() {
		return ("Butilki v ceha: " + this.bottlesCapacity + "; Burkani v ceha: " + this.burkaniCapacity + "\n");
	}
}
