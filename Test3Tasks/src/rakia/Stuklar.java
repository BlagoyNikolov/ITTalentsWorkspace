package rakia;

import java.util.Random;

public class Stuklar extends Thread {
	private StuklarskiCeh ceh;
	private int butilkiToAdd = 40;
	private int burkaniToAdd = 30;

	public Stuklar(StuklarskiCeh ceh, String name) {
		this.ceh = ceh;
		this.setName(name);
	}
	
	@Override
	public void run() {
		while (true) {
			boolean willAddButilki = new Random().nextBoolean();
			if (willAddButilki) {
				this.ceh.addButilkiToStuklarskiCeh(this.butilkiToAdd);
				System.out.println(this.getName() + " dobavi " + this.butilkiToAdd + "butilki v ceha");
			} else {
				this.ceh.addBurkaniToStuklarskiCeh(burkaniToAdd);
				System.out.println(this.getName() + " dobavi " + this.burkaniToAdd + "burkana v ceha");
			}
			try {
				System.out.println(this.getName() + " pravi butilka/burkan za 7s");
				Thread.sleep(7*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
