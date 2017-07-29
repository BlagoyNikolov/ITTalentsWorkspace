package lesson17.abstraction;

public class BoomShop {

	private Explodable[] explosives;
	private int freePlaces;
	
	public BoomShop() {
		this.explosives = new Explodable[10];
		this.freePlaces = explosives.length;
	}
	
	public void addExplodingDevice(Explodable e){
		if(freePlaces <= 0) {
			System.err.println("no more room!");
		}
		else{
			explosives[explosives.length - freePlaces--] = e;
		}
	}
	
	public void blowAllUp(){
		for (int i = 0; i < explosives.length; i++) {
			Explodable e = explosives[i];
			if(e != null){
				e.blowUp();
			}
		}
	}
}
