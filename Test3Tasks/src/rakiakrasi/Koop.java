package rakiakrasi;

public class Koop {

	private int butilki = 0;
	private static final int MAX_BUTILKI = 400;
	
	public synchronized void addRakia(int rakia) {
		while(this.butilki > MAX_BUTILKI-rakia){
			try {this.wait();} catch (InterruptedException e) {}
		}
		this.butilki+=rakia;
		System.out.println(Thread.currentThread().getName() + " added " + rakia + " rakia to koop");
		this.notifyAll();
	}

	public synchronized void removeRakia(int rakia) {
		while(this.butilki < rakia){
			try {this.wait();} catch (InterruptedException e) {}
		}
		this.butilki-=rakia;
		System.out.println(Thread.currentThread().getName() + " removed " + rakia + " rakia from koop");
		this.notifyAll();
	}

}
