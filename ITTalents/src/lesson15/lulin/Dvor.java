package lesson15.lulin;

import java.util.Random;

public class Dvor {

	private final String name;
	private final Zubarche[] zubri;
	
	public Dvor(String name, int numberOfZubari) {
		this.name = name;
		zubri = new Zubarche[numberOfZubari];
		for (int i = 0; i < zubri.length; i++) {
			zubri[i] = new Zubarche("Misho " + (i+1));
		}
	}
	
	public Zubarche getRandomZubarOtDvora(){
		return this.zubri[new Random().nextInt(this.zubri.length)];
	}
	
}
