package hr;

public class Country {
	private int countryId;
	private String name;
	
	public Country(int countryId, String name) {
		this.countryId = countryId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[countryId = " + countryId + ", name = " + name + "]";
	}
	
	
}
