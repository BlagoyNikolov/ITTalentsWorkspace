package immingrants;

import java.util.ArrayList;

import immingrants.weapons.Weapon;

public class NormalImmigrant extends Immigrant {

	public NormalImmigrant(Passport passport, int money, ArrayList<Immigrant> relatives) {
		//TODO validate pass
		super(passport, money, relatives, new ArrayList<>());
	}

	@Override
	protected boolean validRelatives(ArrayList<Immigrant> relatives2) {
		return super.validRelatives(relatives2) && relatives2.size() <= 10;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}
	
	@Override
	public void act() {
		System.out.println("Nothing to do");
	}
}
