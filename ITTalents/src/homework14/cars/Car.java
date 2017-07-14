package homework14.cars;

public class Car {
	private String brand;
	private String model;
	private String color;
	private double maxSpeed;
	private double currentSpeed = 50;
	private int currengear = 1;
	private Person owner;
	private double price;
	private boolean isSportCar;
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		if (!brand.isEmpty() && brand != null) {
			this.brand = brand;
		} else {
			System.out.println("Invalid brand");
		}
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		if (!model.isEmpty() && model != null) {
			this.model = model;
		} else {
			System.out.println("Invalid model");
		}
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		if (!color.isEmpty() && color != null) {
			this.color = color;
		} else {
			System.out.println("Invalid color");
		}
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("Invalid price");
		}
	}
	
	public boolean isSportCar() {
		return isSportCar;
	}
	
	public void setSportCar(boolean isSportCar) {
		this.isSportCar = isSportCar;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	public void setOwner(Person owner) {
		if (owner != null) {
			this.owner = owner;
		} else {
			System.out.println("Invalid owner");
		}
	}
	
	public Car(String modelParam, boolean isSportCarParam, String colorParam) {
		this.setModel(modelParam);
		this.setSportCar(isSportCarParam);
		this.setColor(colorParam);
	}
	
	public Car(String brand, String modelParam, boolean isSportCarParam, String colorParam, double price) {
		this(modelParam, isSportCarParam, colorParam);
		this.setBrand(brand);
		this.setPrice(price);
	}
	
	boolean isMoreExpensive(Car car) {
		return this.getPrice() > car.getPrice();
	}
	
	double calculateCarPriceForScrap(double metalPrice) {
		double coef = 0.2;
		if (this.getColor().equals("black") || this.getColor().equals("white")) {
			coef += 0.05;
		}
		if (this.isSportCar()) {
			coef += 0.05;
		}
		return metalPrice * coef;
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
		setColor(newColor);
	}
}
