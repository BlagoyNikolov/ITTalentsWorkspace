package sol.spaceObjects;

import java.util.ArrayList;

import sol.ISatellite;

public abstract class Planet extends SpaceObject implements ISatellite {
	protected ArrayList<ISatellite> moons;
	protected Sun sun;
	
	public Planet(String name, int size, String type, int volume, int temperature, Sun sun, ArrayList<ISatellite> moons) {
		super(name, size, type, volume, temperature);
		this.sun = sun;
		this.moons = moons;
	}
}
