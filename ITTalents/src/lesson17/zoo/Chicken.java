package lesson17.zoo;

public class Chicken extends Animal {

	public Chicken(String name) {
		super(name);
	}

	@Override
	public void feed() {
		System.out.println("chok chok");
	}

	@Override
	void makeNoise() {
		System.out.println("kut kut!");
	}
	
	void reactToSunBlock(){
		System.out.println("o fuck ...");
		this.sleep();
	}

}
