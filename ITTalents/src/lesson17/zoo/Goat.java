package lesson17.zoo;

public class Goat extends Animal{

	Goat(String name) {
		super(name);
	}

	@Override
	public void feed() {
		System.out.println("pasem treva kato kozi");
	}

	@Override
	void makeNoise() {
		System.out.println("Beeee");
	}

}
