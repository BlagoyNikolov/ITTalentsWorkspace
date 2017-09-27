package court.citizens;

import java.util.ArrayList;

import court.jurists.Lawyer;

public abstract class LawyerClient extends Citizen {
	protected ArrayList<Lawyer> lawyers;
	
	public LawyerClient(String names, int age, String address, ArrayList<Lawyer> lawyers) {
		super(names, age, address);
		this.lawyers = lawyers;
	}
	
	public ArrayList<Lawyer> getLawyers() {
		return lawyers;
	}

}
