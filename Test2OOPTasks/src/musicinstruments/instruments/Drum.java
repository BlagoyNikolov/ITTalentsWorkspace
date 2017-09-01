package musicinstruments.instruments;

public class Drum extends Instrument {

	public Drum(String name, double price, int availability) {
		super(name, price, availability, InstrumentType.HIT);
	}

	@Override
	public String toString() {
		return "Drum [name=" + name + ", price=" + price + ", availability=" + availability + ", type=" + type + "]";
	}
	
	

}
