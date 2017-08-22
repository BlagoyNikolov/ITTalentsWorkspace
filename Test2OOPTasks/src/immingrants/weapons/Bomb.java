package immingrants.weapons;

import java.util.Random;

public class Bomb extends Weapon{

	public Bomb(int price) {
		super(price);
	}

	@Override
	public int shoot() {
		System.out.println("BOOOOM NATIVE PEOPLE!!!");
		return -1;//monkey hack
	}

	@Override
	public boolean isRadical() {
		return false;
	}
	
	public boolean isBomb(){ return true; }
}
