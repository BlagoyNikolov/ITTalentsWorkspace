package immingrants;

import java.util.ArrayList;
import java.util.Random;

import immingrants.cops.Officer;
import immingrants.cops.PoliceMan;
import immingrants.cops.Swat;

public class City {

	private Country country;
	private String name;
	private ArrayList<PoliceMan> police;
	private int citizens;
	private ArrayList<Immigrant> immigrants;
	
	public String getName() {
		return name;
	}

	public City(String name){
		this.name = name;

		Random r = new Random();
		this.police = new ArrayList<>();
		for(int i = 0; i < r.nextInt(20)+20; i++){
			if(r.nextBoolean()){
				this.police.add(new Officer("Policai " + i, this));
			}
			else{
				this.police.add(new Swat("Swatadjia " + i, this));
			}
		}
		//TODO nope - this is not correct - correct only if losePeople can lose policemen and immigrants
		this.citizens = new Random().nextInt(1000)+1000;
		this.immigrants = new ArrayList<>();
	}

	public Country getCountry() {
		return country;
	}
	
	public PoliceMan getRandomPoliceMan(){
		return this.police.get(new Random().nextInt(police.size()));
	}

	public void addImmigrant(Immigrant immigrant) {
		this.immigrants.add(immigrant);
		this.citizens++;
	}

	//TODO consider killing policemen and other immigrants
	public void losePeople(int casualties) {
		this.citizens-=casualties;
		if(citizens < 0){
			citizens = 0;
		}
	}

	public void dissappear() {
		this.country.removeCity(this);
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
