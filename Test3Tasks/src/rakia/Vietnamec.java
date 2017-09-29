package rakia;

public class Vietnamec extends Thread {
	private ZaharenZavod zavod;
	private int kpd = 45;

	public Vietnamec(ZaharenZavod zavod, String name) {
		this.zavod = zavod;
		this.setName(name);
	}
	
	@Override
	public void run() {
		while (true) {
			this.zavod.addToZzgo(kpd);
			System.out.println(this.getName() + " dobavi " + this.kpd + "kg zaharna trustika v zavoda");
			try {
				System.out.println(this.getName() + " bere zaharna trustika za 5s");
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
