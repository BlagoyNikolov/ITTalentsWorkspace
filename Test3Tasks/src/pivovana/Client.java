package pivovana;

import java.util.Random;

public class Client implements Runnable {

	private String name;
	private double money;
	private ITrade dePazaruvam;
	
	public Client(String name, double money, ITrade dePazaruvam) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		if(money >= 0){
			this.money = money;
		}
		if(dePazaruvam != null){
			this.dePazaruvam = dePazaruvam;
		}
	}

	@Override
	public void run() {
		while(true){
			this.dePazaruvam.buyBeer(this, new Random().nextInt(3) + 1);
			System.out.println(this.name + "si kupi bira ot " + this.dePazaruvam.getName());
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				System.out.println("Ne mojah da stigna magazina, ba!");
			}
		}
		
	}

	public String getName() {
		return name;
	}
	

	
	
}
