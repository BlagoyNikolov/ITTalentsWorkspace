package lesson17.zoo;

public class Sheep extends Animal implements Strijable {

	public Sheep(String name) {
		super(name);
	}

	@Override
	public void feed() {
		System.out.println("pase kato ovca - mlqs mlqs");
	}

	@Override
	public void striji() {
		System.out.println("strij strij");
	}

	@Override
	void makeNoise() {
		System.out.println("blee blee kato ovca");
	}

}
