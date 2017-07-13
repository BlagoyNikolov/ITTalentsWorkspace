package homework14.cars;

public class Car {
	String brand;
	String model;
	String color;
	double maxSpeed;
	double currentSpeed = 50;
	int currengear = 1;
	Person owner;
	double price;
	boolean isSportCar;
	
	void changeOwner(Person newOwner) {
		this.owner = newOwner;
	}
	
	public Car(String modelParam, boolean isSportCarParam, String colorParam) {
		model = modelParam;
		isSportCar = isSportCarParam;
		color = colorParam ;
	}
	
	boolean isMoreExpensive(Car car) {
		return this.price > car.price;
	}
	
	void accelerate(){
		if (currentSpeed < maxSpeed) {
			currentSpeed++;	
		}
	}
	
	void changegearUp() {
		if (currengear >= 1 && currengear < 5) {
			currengear++;
		}
	}
	
	void changegearDown() {
		if (currengear > 1 && currengear <= 5) {
			currengear--;
		}
	}
	
	void changeGear(int nextGear) {
		if (currengear >= 1 && currengear <= 5) {
			currengear = nextGear;
		}
	}
	
	void changeColor(String newColor) {
		color = newColor;
	}
}
