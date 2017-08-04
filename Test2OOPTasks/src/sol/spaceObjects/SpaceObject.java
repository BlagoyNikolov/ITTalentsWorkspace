package sol.spaceObjects;

public abstract class SpaceObject {
	protected String name;
	protected int size;
	protected String type;
	protected int volume;
	protected int temperature;
	
	public SpaceObject(String name, int size, String type, int volume, int temperature) {
		this.name = name;
		this.size = size;
		this.type = type;
		this.volume = volume;
		this.temperature = temperature;
	}
}
