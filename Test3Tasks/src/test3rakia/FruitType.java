package test3rakia;

import java.util.Random;

public enum FruitType {
	GROZDE, SLIVI, KAISII;
	
	public static FruitType getRandomFruitType() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return GROZDE;
		case 1:
			return SLIVI;
		case 2:
			return KAISII;
		default:
			return null;
		}
	}
}
