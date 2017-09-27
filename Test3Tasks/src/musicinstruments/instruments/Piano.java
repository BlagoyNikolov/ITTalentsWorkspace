package musicinstruments.instruments;

public class Piano extends Instrument{

	public Piano(String name, double price, int availability) {
		super(name, price, availability, InstrumentType.KEY, 8);
	}

	@Override
	public String toString() {
		return "Piano [name=" + name + ", price=" + price + ", availability=" + availability + ", type=" + type + "]";
	}

}
