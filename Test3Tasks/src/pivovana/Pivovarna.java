package pivovana;

public class Pivovarna implements Runnable {

	private String name;
	private double money;
	private int beer;
	private static final int MIN_BEER = 0;
	private static final int MAX_BEER = 30;

	public Pivovarna(String name, double money) {
		this.beer = 0;
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (money >= 0) {
			this.money = money;
		}
	}

	Object anotherLock = new Object();
	
	@Override
	public void run() {
		while (true) {
			if (this.beer + 10 > MAX_BEER) {
				synchronized(anotherLock){
					try {
						System.out.println("Mnogo bira, pivovrnata zaspa.");
						anotherLock.wait();
					} catch (InterruptedException e) {
						System.out.println("Some error");
					}
				}
			} else {
				this.beer += 10;
				System.out.println(this.getName() + " sgotvi bira. 10 litra.");
				someLock.notifyAll();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					System.out.println("Ni moa varq!");
				}
			}
		}
	}

	Object someLock = new Object();
	
	public void exportBeer(ITrade t, int i) {
		synchronized (someLock) {
			if(i > this.beer){
				try {
					System.out.println(t.getName() + " zaspa, shtoto nqma tolkoz bira v pivovarnata.");
					someLock.wait();
				} catch (InterruptedException e) {
					System.out.println("Dunno!");
				}
			}else{
				t.addBeer(i);
				System.out.println(this.name + " dade " + i + "litra bira na " + t.getName());
				anotherLock.notifyAll();
			}
		}
		
		
	}

	public String getName() {
		return name;
	}

}
