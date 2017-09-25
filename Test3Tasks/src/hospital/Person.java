package hospital;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String phone;
	
	public Person(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return (getFirstName() + " " + getLastName());
	}
}
