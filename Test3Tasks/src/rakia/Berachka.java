package rakia;

public class Berachka extends Thread {
	private Bidon bidon;
	private int kpd = 10;

	public Berachka(Bidon bidon, String name) {
		this.bidon = bidon;
		this.setName(name);
	}
	
	@Override
	public void run() {
		while (true) {
			this.bidon.addToBidona(kpd);
			System.out.println(this.getName() + " dobavi " + this.kpd + "kg grozdence v bidonq");
			try {
				System.out.println(this.getName() + " bere grozde za 2s");
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
