package lesson15.examples;

public class Person {

	private static Feeling[] feelings;
	
	private final char gender;
	private String name;
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	Person(char gender){
		//TODO validate here, you must!
		this.gender = gender;
	}
	
}
