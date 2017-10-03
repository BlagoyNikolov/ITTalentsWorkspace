package test3rakia;

public class RakiaMan extends Person {
	private FruitType rakiaType;
	private Kazan kazan;

	public RakiaMan(String name, int age, Kazan kazan) {
		super(name, age);
		this.kazan = kazan;
		this.rakiaType = FruitType.getRandomFruitType();
	}
	
	public FruitType getRakiaType() {
		return rakiaType;
	}
	
	@Override
	public void run() {
		while (true) {
			this.kazan.removeFromKazana(this);
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
