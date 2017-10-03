package test3rakia;

public class Berach extends Person {
	private FruitType fruitType;
	private Kazan kazan;

	public Berach(String name, int age, Kazan kazan) {
		super(name, age);
		this.kazan = kazan;
		this.fruitType = FruitType.getRandomFruitType();
	}
	
	public FruitType getFruitType() {
		return fruitType;
	}
	
	@Override
	public void run() {
		while (true) {
			this.kazan.addToKazana(this, 1);
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
