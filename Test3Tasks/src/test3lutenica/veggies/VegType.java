package test3lutenica.veggies;

import java.util.Random;

public enum VegType {
	DOMAT, CHUSHKA, PATLAJAN;
	
	public static VegType getRandomVegType() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return DOMAT;
		case 1:
			return CHUSHKA;
		case 2:
			return PATLAJAN;
		default:
			return null;
		}
	}
}
