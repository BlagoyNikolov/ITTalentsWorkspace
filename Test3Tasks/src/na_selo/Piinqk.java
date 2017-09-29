package na_selo;

import java.util.Random;
import na_selo.Store.Stoki;

public class Piinqk extends Person {

	private Store store;
	private int izpitiButilki;
	
	public Piinqk(String name, Store store) {
		super(name, 2);
		this.store = store;
		this.izpitiButilki = 0;
	}

	@Override
	void work() {
		int butilki = new Random().nextInt(5) + 1;
		store.get(Stoki.RAKIQ, butilki);
		this.izpitiButilki += butilki;
		System.out.println("Podai " + butilki + " rakii tam");
		
		store.get(Stoki.KOMPOT, 5);
		System.out.println("Dai " + 5 + " kompota tam");
	}

	public int getIzpitiButilki() {
		return izpitiButilki;
	}
}
