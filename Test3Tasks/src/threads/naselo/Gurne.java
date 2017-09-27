package threads.naselo;

import java.util.concurrent.atomic.AtomicInteger;

public class Gurne {

	private AtomicInteger quantityofBob = new AtomicInteger(10);//kg
	
	public int getQuantityofBob() {
		return quantityofBob.get();
	}
	
	public synchronized void removeBob(int bob){
		while(quantityofBob.get() <= 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.quantityofBob.addAndGet(-bob);
		this.notifyAll();
		System.out.println("Bob removed - remaining = " + quantityofBob);
	}
	
	public synchronized void addBob(int bob) {
		while(quantityofBob.get() >= 20) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.quantityofBob.addAndGet(bob);
		this.notifyAll();
		System.out.println("Bob added - remaining = " + quantityofBob);
	}
}
