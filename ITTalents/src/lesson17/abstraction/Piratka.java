package lesson17.abstraction;

public class Piratka extends Product implements Explodable {

	public Piratka(String name, int price) {
		super(price, name);
	}

	@Override
	public void blowUp() {
		System.out.println("palim i ai chao");
	}
}
