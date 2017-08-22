package immingrants.cops;

import java.util.Random;

import immingrants.City;
import immingrants.Immigrant;

public class Swat extends PoliceMan {

	public Swat(String name, City city) {
		super(name, city);
	}

	@Override
	public boolean check(Immigrant i) {
		if(i.isLegal()){
			return true;
		}
		else{
			return new Random().nextInt(10) == 1;//an awful way to return true in 10% of times
		}
	}
}