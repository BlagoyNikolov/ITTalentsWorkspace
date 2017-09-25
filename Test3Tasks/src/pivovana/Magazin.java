package pivovana;

public class Magazin implements ITrade {

	private String name;
	private Pivovarna p;
	private double money;
	private int beer;
	private static final int MIN_BEER = 0;
	private static final int MAX_BEER = 10;

	public Magazin(String name, Pivovarna p, double money) {
		this.beer = 0;
		this.p = p;
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (money >= 0) {
			this.money = money;
		}
	}

	Object magazinLock = new Object();

	@Override
	public void buyBeer(Client c, int i) {
		synchronized (magazinLock) {
			if (i > this.beer) {
				getBeerFromPivovarna();
				try {
					System.out.println(c.getName() + " zaspa.");
					wait();
				} catch (InterruptedException e) {
					System.out.println("Izritaha ma ot magazina");
				}
			} else {
				this.beer -= i;
			}
		}
	}

	private void getBeerFromPivovarna() {
		System.out.println("Shte se zarejda bira");
		p.exportBeer(this, 5);
	}

	public synchronized void addBeer(int added) {
		this.beer += added;
		System.out.println(this.name + " mu dostaviha bira ot pivovarna " + this.p.getName() + ". Obshto litri: " + added);
		magazinLock.notifyAll();
	}

	public String getName() {
		return name;
	}

}
