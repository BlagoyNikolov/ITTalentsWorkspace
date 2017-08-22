package immingrants;

import java.util.ArrayList;
import java.util.Iterator;

import immingrants.cops.PoliceMan;
import immingrants.weapons.Weapon;

public abstract class Immigrant {

	private Passport passport;
	private int money;
	protected City city;
	private ArrayList<Immigrant> relatives;
	protected ArrayList<Weapon> weapons;
	
	public Immigrant(Passport passport, int money, ArrayList<Immigrant> relatives, ArrayList<Weapon> weapons) {
		this.passport = passport;
		this.money = money;
		if(validRelatives(relatives)){
			this.relatives = relatives;
		}
		else{
			this.relatives = new ArrayList<>();
		}
		
		this.weapons = weapons == null ? new ArrayList<>() : filterWeapons(weapons);
	}
	
	protected ArrayList<Weapon> filterWeapons(ArrayList<Weapon> weps) {
		return weps;
	}

	protected boolean validRelatives(ArrayList<Immigrant> relatives2){
		return relatives2 != null;
	}
	
	public abstract boolean isLegal();

	public void enterCountry(Country country)
	{	
		City c = country.getRandomCity();
		this.enterCity(c);
	}
	
	private void enterCity(City c){
		PoliceMan p = c.getRandomPoliceMan();
		if(p.check(this)){
			c.addImmigrant(this);
			this.city = c;
			for(int i = 0; i < this.relatives.size(); i++){
				if(relatives.get(i).city != c){
					relatives.get(i).enterCity(c);
				}
			}
		}
		else{
			System.out.println("Sori bace, ne ni kefish!");
		}
	}
	
	protected Passport getPassport() {
		return passport;
	}

	public boolean carryBomb() {
		for (int i = 0; i < weapons.size(); i++) {
			if(weapons.get(i).isBomb()){
				return true;
			}
		}
		return false;
	}
	
	public boolean buyWeapon(Weapon w){
		if(w.getPrice() > this.money){
			System.out.println("Umiram ot qd");
			//TODO remove from country
			return false;
		}
		else{
			this.money -= w.getPrice();
			this.weapons.add(w);
			this.weapons = filterWeapons(weapons);
			return true;
		}
	}
	
	@Override
	public String toString() {
		String info = city == null ? "NOWHERE" : city.getName();
		info += this.passport == null ? " NO PASSPORT" : "HAS PASSPORT";
		info += this.money;
		info += "relatives: todo";
		return info;
	}
	
	public City getCity() {
		return city;
	}
	
	public abstract void act();
}
