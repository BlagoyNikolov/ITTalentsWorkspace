package sol.spaceObjects;

import java.util.ArrayList;

import sol.ISatellite;

public final class Sun extends SpaceObject {
	private ArrayList<ISatellite> satellites;
	
	public Sun(String name, int size, String type, int volume, int temperature, ArrayList<ISatellite> satellites) {
		super(name, size, type, volume, temperature);
		this.satellites = satellites;
	}

}
