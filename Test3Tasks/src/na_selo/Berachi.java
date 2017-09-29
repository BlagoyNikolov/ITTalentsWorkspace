package na_selo;

import java.util.Random;

public class Berachi extends Person {

	private Bidon bid;
	
	public Berachi(String name, Bidon bid) {
		super(name, 3);
		this.bid = bid;
	}

	@Override
	void work() {
		bid.add(new Random().nextInt(15) + 10);
	}

}
