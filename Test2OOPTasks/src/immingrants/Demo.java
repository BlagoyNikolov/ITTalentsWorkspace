package immingrants;

import java.util.ArrayList;
import java.util.Random;

import immingrants.cops.PoliceMan;
import immingrants.weapons.Bomb;
import immingrants.weapons.Gun;
import immingrants.weapons.Rifle;
import immingrants.weapons.Weapon;

public class Demo {

	public static void main(String[] args) throws InvalidCityException {
		
		
		Country c = new Country("BG", 5);
		
		System.out.println(c);

		ArrayList<Weapon> weapons = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			Weapon w = null;
			int chance = new Random().nextInt(3);
			switch (chance) {
			case 0:
				w = new Gun(130);
				break;
			case 1:
				w = new Rifle(420);
				break;
			case 2:
				w = new Bomb(2500);
				break;

			default:
				break;
			}
			weapons.add(w);
		}
		
		ArrayList<Immigrant> immigrants = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			int chance = new Random().nextInt(100);
			if(chance < 25){
				Passport p = null;
				if(new Random().nextInt(100) < 35){
					p = new Passport("Penio-AlDjaziri-AlMaziri", 30, "Abudabi");
				}
				immigrants.add(new RadicalImmigrant(p, 500000, getRandom2(immigrants), weapons));
			}
			else
			if(chance >= 25 && chance <60){
				immigrants.add(new ExtremistImmigrant(500000, getRandom2(immigrants), weapons));
			}
			else{
				Passport p = new Passport("Georgi normalnia", 22, "Dubai");
				immigrants.add(new NormalImmigrant(p, 500000, getRandom2(immigrants)));
			}
			
		}
		
		for(int i = 0; i < immigrants.size(); i++){
			for(int j = 0; j < 5; j++){
				if(weapons.size() > 0){
					Weapon w = weapons.get(new Random().nextInt(weapons.size()));
					if(immigrants.get(i).buyWeapon(w)){
						weapons.remove(w);
					}
				}
			}
		}
		

		for(int i = 0; i < immigrants.size(); i++){
			immigrants.get(i).enterCountry(c);
		}

		for(int i = 0; i < 100; i++){
			Immigrant im = immigrants.get(new Random().nextInt(immigrants.size()));
			if(im.getCity() != null){
				im.act();
			}
		}
		
		System.out.println("=================");
		System.out.println(c);
	}

	private static ArrayList<Immigrant> getRandom2(ArrayList<Immigrant> immigrants) {
		ArrayList<Immigrant> randoms = new ArrayList<>();
		if(immigrants.size() == 0){
			return randoms;
		}
		randoms.add(immigrants.get(new Random().nextInt(immigrants.size())));
		randoms.add(immigrants.get(new Random().nextInt(immigrants.size())));
		return randoms;
	}
}
