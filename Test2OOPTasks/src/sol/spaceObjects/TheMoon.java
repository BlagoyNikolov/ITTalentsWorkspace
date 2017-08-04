package sol.spaceObjects;

public final class TheMoon extends Moon {
	public TheMoon(String name, int size, String type, int volume, int temperature, Planet planet) {
		super(name, size, type, volume, temperature, planet);
	}

	@Override
	public SpaceObject getCenterObject() {
		return this.planet;
	}
}
