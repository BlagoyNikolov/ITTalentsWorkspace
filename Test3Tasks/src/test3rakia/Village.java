package test3rakia;

import java.util.ArrayList;
import java.util.Random;

public class Village {
	private ArrayList<Kazan> kazani;

	public Village() {
		this.kazani = new ArrayList<Kazan>();
		for (int i = 0; i < 5; i++) {
			this.kazani.add(new Kazan("Kazan" + i));
		}
	}

	public Kazan getRandomKazan() {
		return this.kazani.get(new Random().nextInt(this.kazani.size()));
	}
	
	public void startLogging() {
		for (Kazan kazan : kazani) {
			new Thread(() -> {
				kazan.writeToFile();
				
			}).start();
		}
	}
}
