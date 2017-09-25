package threads.naselo;

import java.util.concurrent.ArrayBlockingQueue;

public class Gurne {
	private int bob = 200;
	private static final int MAX = 100;
	private static final int MIN = 50;
	
	public ArrayBlockingQueue<Integer> gurne = new ArrayBlockingQueue<>(MAX);
	
	public void sipiBob() {
		try {
			gurne.put(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Babata sipa bob, v gurneto ima " + gurne.size());
	}
	
	public void qjBob() {
		try {
			gurne.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Babata sipa bob, v gurneto ima " + gurne.size());
	}

//	public synchronized void sipiBob() {
//		if (this.bob < MAX) {
//			this.bob += 10;
//			System.out.println("Babata sipa bob, v gurneto ima " + this.bob);
//			notifyAll();
//		} else {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
//	public synchronized void qjBob() {
//		if (this.bob > MIN) {
//			this.bob -= 10;
//			System.out.println("Vnucheto naguna bob, v gurneto ima " + this.bob);
//			notifyAll();
//		} else {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
