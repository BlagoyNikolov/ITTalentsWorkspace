package threads.bob;

import java.util.concurrent.ArrayBlockingQueue;

public class Gurne {

	ArrayBlockingQueue<Integer> gurne = new ArrayBlockingQueue(50);
	
	
	public void sipiBob(){
		try {
			gurne.put(1);
		} catch (InterruptedException e) {System.out.println("ops");}
		System.out.println("Babata sipa bob, sega gurneto e s " + (gurne.size()) + " grama");
	}
	
	public void hapniBob(){
		try {
			gurne.take();
		} catch (InterruptedException e) {System.out.println("ops");}
		System.out.println("Vnucheto hapna bob, sega gurneto e s " + (gurne.size()) + " grama");
	}
}
