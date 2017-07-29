package lesson17.abstraction;

public class Nitro extends Product implements Explodable, IFragile {

	public Nitro(int price, String name) {
		super(price, name);
	}

	@Override
	public void crack() {
		System.out.println("Crack ... 3.. 2..1.. ");
		this.blowUp();
	}

	@Override
	public void crash() {
		this.blowUp();
	}

	@Override
	public void blowUp() {
		System.out.println("FLAMES!");
	}

}
