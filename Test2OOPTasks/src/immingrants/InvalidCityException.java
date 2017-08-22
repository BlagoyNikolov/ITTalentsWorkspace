package immingrants;

public class InvalidCityException extends Exception {

	@Override
	public String getMessage() {
		return "City cannot be empty!";
	}

}
