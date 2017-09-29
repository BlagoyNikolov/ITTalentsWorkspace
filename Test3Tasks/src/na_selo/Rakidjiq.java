package na_selo;

import na_selo.Store.Stoki;

public class Rakidjiq extends Person {

	private Bidon bid;
	private Store store;
	
	public Rakidjiq(String name, Bidon bid, Store store) {
		super(name, 3);
		this.bid = bid;
		this.store = store;
	}

	@Override
	void work() {
		bid.get(25);
		store.add(Stoki.RAKIQ, 5);
	}
}
