package test3lutenica.veggies;

public abstract class Vegetable {
	private String name;
	private int timeToProcess;
	private VegType type;
	
	public Vegetable(String name, int timeToProcess, VegType type) {
		this.name = name;
		this.timeToProcess = timeToProcess;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getTimeToProcess() {
		return timeToProcess;
	}

	public VegType getType() {
		return type;
	}
}
