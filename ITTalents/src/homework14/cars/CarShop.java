package homework14.cars;

public class CarShop {
	private Car[] cars;

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		if (cars != null) {
			this.cars = cars;
		} else {
			System.out.println("Invalid array of cars");
		}
	}

	public CarShop(int capacity) {
		if (capacity >= 0) {
			this.setCars(new Car[capacity]);
		} else {
			System.out.println("Invalid capacity of array of cars");
		}
	}

	public boolean addCar(Car car) {
		for (int i = 0; i < this.getCars().length; i++) {
			if (car != null && this.getCars()[i] == null) {
				this.getCars()[i] = car;
				return true;
			}
		}
		return false;
	}

	public Car getNextCar() {
		for (int i = 0; i < this.getCars().length; i++) {
			if (this.getCars()[i] != null) {
				return this.getCars()[i];
			}
		}
		return null;
	}

	public void sellNextCar(Person buyer) {
		Car carToSell = this.getNextCar();
		buyer.buyCar(carToSell);
		carToSell.setOwner(buyer);
		this.removeCar(carToSell);
		System.out.println("Car " + carToSell.getBrand() + " " + carToSell.getModel() + " successfully sold to " + carToSell.getOwner().getName() + " for " + carToSell.getPrice());
	}

	public boolean removeCar(Car car) {
		for (int i = 0; i < this.getCars().length; i++) {
			//if (this.getCars()[i].getBrand().equals(car.getBrand()) && this.getCars()[i].getModel().equals(car.getModel())) {
			if (this.getCars()[i].equals(car)) {
				this.getCars()[i] = null;
				return true;
			}
		}
		return false;
	}

	public void showAllCarsInTheShop() {
		for (int i = 0; i < this.getCars().length; i++) {
			if (this.getCars()[i] != null) {
				//System.out.println("Brand: " + this.getCars()[i].brand + ", Model: " + this.getCars()[i].model + ", Color " + this.getCars()[i].color + ", Price: " + this.getCars()[i].price + ", Owner: " + this.getCars()[i].owner.name);
				System.out.println("Brand: " + this.getCars()[i].getBrand() + ", Model: " + this.getCars()[i].getModel() + ", Color " + this.getCars()[i].getColor() + ", Price: " + this.getCars()[i].getPrice());
			}
		}
	}
}
