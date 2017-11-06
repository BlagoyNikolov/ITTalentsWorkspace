package crossroads;

public class Cross {
	
	public synchronized void enter(Traveller traveller) {
		System.out.println(traveller.getName() + " entered");
		boolean isBlocked = false;
		while(isBlocked) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		System.out.println(traveller.getName() + " exited");
	}
}
