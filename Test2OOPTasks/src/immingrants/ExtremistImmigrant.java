package immingrants;

import java.util.ArrayList;

import immingrants.weapons.Weapon;

public class ExtremistImmigrant extends Immigrant{

	public ExtremistImmigrant(int money, ArrayList<Immigrant> relatives, ArrayList<Weapon> weapons) {
		super(null, money, relatives, weapons);
	}

	@Override
	public boolean isLegal() {
		return false;
	}
	
	public void blowUp(){
		for(Weapon w : weapons){
			if(w.isBomb()){
				w.shoot();
				System.out.println("Podhodqshto suboshtenie pri bomba!");
				city.dissappear();
			}
		}
	}

	@Override
	public void act() {
		this.blowUp();
	}
}
