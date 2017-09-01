package musicinstruments.instruments;

public abstract class Instrument implements Comparable<Instrument> {
	public enum InstrumentType {
		STRING, KEY, ELECTRONIC, HIT, BLOW;
	}
	
	protected String name;
	protected double price;
	protected int availability;
	protected InstrumentType type;
	
	public Instrument(String name, double price, int availability, InstrumentType type) {
		this.name = name;
		this.price = price;
		this.availability = availability;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return this.price;
	}
	
	public int getAvailability() {
		return this.availability;
	}
	
	public InstrumentType getType() {
		return type;
	}

	public void decreaseQuantity(int quantity) {
		this.availability -= quantity;
	}
	
	public void increaseQuantity(int quantity) {
		this.availability += quantity;
	}

	@Override
	public int compareTo(Instrument o) {
		return this.name.compareTo(o.name);
	}
}
