package immingrants;

import java.util.ArrayList;
import java.util.Random;

import immingrants.cops.Officer;
import immingrants.cops.PoliceMan;

public class Country {

	private String name;
	private ArrayList<City> cities;
	private static final String[] NAMES = {"Sofia", "VT", "Burgas", "Varna", "Pleven", "Plovdiv"};

	public Country(String name, int cities) {
		this.name = name;
		this.cities = new ArrayList<City>();
		Random r = new Random();
		for(int i = 0; i < cities; i++){
			City c = new City(NAMES[r.nextInt(NAMES.length)]);
			c.setCountry(this);
			this.cities.add(c);
		}
	}

	public City getRandomCity() {
		return this.cities.get(new Random().nextInt(cities.size()));
	}

	public void removeCity(City city) {
		this.cities.remove(city);
	}
	
	@Override
	public String toString() {
		return name + " with cities : " + cities.toString();
	}
	
}
