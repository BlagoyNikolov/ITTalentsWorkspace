package musicinstruments.instruments;

public class Guitar extends Instrument {

	public Guitar(String name, double price, int availability) {
		super(name, price, availability, InstrumentType.STRING, 2);
	}

	@Override
	public String toString() {
		return "Guitar [name=" + name + ", price=" + price + ", availability=" + availability + ", type=" + type + "]";
	}

}
