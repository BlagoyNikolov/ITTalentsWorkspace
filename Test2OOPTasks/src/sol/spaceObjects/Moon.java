package sol.spaceObjects;

import sol.ISatellite;

public abstract class Moon extends SpaceObject implements ISatellite {
	protected Planet planet;
	
	public Moon(String name, int size, String type, int volume, int temperature, Planet planet) {
		super(name, size, type, volume, temperature);
		this.planet = planet;
	}
}
