package rakia;

public class Shkembejiq extends Thread {
	private Koop koop;
	private int getButilkiRakiq = 5;
	private int izpitiButilki;

	public Shkembejiq(Koop koop, String name) {
		this.koop = koop;
		this.setName(name);
	}
	
	public int getIzpitiButilki() {
		return izpitiButilki;
	}
	
	@Override
	public void run() {
		while (true) {
			this.koop.removeRakiaFromKoop(this.getButilkiRakiq);
			System.out.println(this.getName() + " vze " + this.getButilkiRakiq + "butilki rakiq ot magazinq");
			this.izpitiButilki += this.getButilkiRakiq;
			try {
				System.out.println(this.getName() + " pie 6i6e rakiq za 1s");
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}