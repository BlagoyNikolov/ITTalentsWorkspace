package sol.spaceObjects;

import sol.ISatellite;

public abstract class Comet extends SpaceObject implements ISatellite {
	public Comet(String name, int size, String type, int volume, int temperature) {
		super(name, size, type, volume, temperature);
	}
}
