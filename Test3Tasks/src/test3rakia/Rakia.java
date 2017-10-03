package test3rakia;

import java.time.LocalDateTime;

public class Rakia {
	String maker;
	LocalDateTime date;
	FruitType fruitType;
	int quatity;
	
	public Rakia(String maker, LocalDateTime date, FruitType fruitType, int quatity) {
		this.maker = maker;
		this.date = date;
		this.fruitType = fruitType;
		this.quatity = quatity;
	}

	public String getMaker() {
		return maker;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public FruitType getFruitType() {
		return fruitType;
	}

	public int getQuatity() {
		return quatity;
	}
}
