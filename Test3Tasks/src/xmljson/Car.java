package xmljson;

public class Car {
	private String brand;
	private String model;
	private int hp;
	private int topSpeed;
	private double engineDisplacement;
	
	public Car(String brand, String model, int hp, int topSpeed, double engineDisplacement) {
		this.brand = brand;
		this.model = model;
		this.hp = hp;
		this.topSpeed = topSpeed;
		this.engineDisplacement = engineDisplacement;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", hp=" + hp + ", topSpeed=" + topSpeed
				+ ", engineDisplacement=" + engineDisplacement + "]";
	}
	
}
