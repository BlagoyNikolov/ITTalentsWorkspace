package sol.spaceObjects;

import java.util.ArrayList;

import sol.ISatellite;
import sol.Inhabitable;
import sol.creatures.TravellingCreature;

public final class Earth extends Planet implements Inhabitable {
	private ArrayList<TravellingCreature> travellers;
	
	public Earth(String name, int size, String type, int volume, int temperature, Sun sun, ArrayList<ISatellite> moons) {
		super(name ,size, type, volume, temperature, sun, moons);
	}

	@Override
	public SpaceObject getCenterObject() {
		return this.sun;
	}

	@Override
	public void buildHouse() {
		System.out.println("house built on " + this.name);
	}

	@Override
	public ArrayList<TravellingCreature> getTravellers() {
		return travellers;
	}

	public void setTravellers(ArrayList<TravellingCreature> travellers) {
		this.travellers = travellers;
	}
}
