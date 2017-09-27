package court.court;

import java.util.ArrayList;

import court.jurists.Jurist;

public class Court {
	private String name;
	private String address;
	private ArrayList<Jurist> lica;
	private ArrayList<Case> cases;
	
	public Court(String name, String address, ArrayList<Jurist> lica, ArrayList<Case> cases) {
		this.name = name;
		this.address = address;
		this.lica = lica;
		this.cases = cases;
	}
	
	
}
