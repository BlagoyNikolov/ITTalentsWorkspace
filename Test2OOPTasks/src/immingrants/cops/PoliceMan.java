package immingrants.cops;

import immingrants.City;
import immingrants.Immigrant;

public abstract class PoliceMan {

	private String name;
	private City city;
	
	public PoliceMan(String name, City city) {
		this.name = name;
		this.city = city;
	}
	
	public abstract boolean check(Immigrant i);
}
