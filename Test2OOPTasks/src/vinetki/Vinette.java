package vinetki;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Vinette {
	public enum VehicleType {
		CAR(5, "Blue"), TRUCK(7, "Yellow"), BUS(9, "Red");
		
		private double price;
		private String color;
		
		private VehicleType (double price, String color) {
			this.price = price;
			this.color = color;
		}
	}
	
	public enum ValidPeriod {
		DAY(1), MONTH(10), YEAR(60);
		
		private double coefficient;
		
		private ValidPeriod (double coefficient) {
			this.coefficient = coefficient;
		}
	}
	
	private LocalDate date;
	private VehicleType type;
	private ValidPeriod period;
	private String color;
	private double price;
	private boolean isStuck;
	
	public Vinette(VehicleType type) {
		this.type = type;
	}
	
	public Vinette(LocalDate date, VehicleType type, ValidPeriod period) {
		this.date = date;
		this.type = type;
		this.period = period;
		this.price = calculatePrice();
		this.color = getColor();
		this.isStuck = false;
	}
	
	public int stickOnGlass(Vinette v) {
		if (!this.isStuck) {
			this.isStuck = true;
			if (v.getColor().equals("Blue")) {
				return 5;
			}
			if (v.getColor().equals("Red")) {
				return 20;
			}
			if (v.getColor().equals("Yellow")) {
				return 10;
			}
		}
		return 0;
	}
	
	public static VehicleType getRandomType() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return VehicleType.CAR;
		case 1:
			return VehicleType.TRUCK;
		case 2:
			return VehicleType.BUS;
		}
		return null;
	}
	
	public static ValidPeriod getRandomPeriod() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return ValidPeriod.DAY;
		case 1:
			return ValidPeriod.MONTH;
		case 2:
			return ValidPeriod.YEAR;
		}
		return null;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public VehicleType getType() {
		return this.type;
	}
	
	public ValidPeriod getPeriod() {
		return this.period;
	}
	
	public String getColor() {
		return this.type.color;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean isStuck() {
		return isStuck;
	}
	
	public double calculatePrice() {
		return this.type.price * this.period.coefficient;
	}
	
	public String toString() {
		return "Vinetka [type=" + getType() + ", color=" + getColor() + ", period=" + getPeriod() + ", priceVinetka=" + getPrice() + "]";
	}
}
