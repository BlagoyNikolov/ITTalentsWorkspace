package test3rakia;

public class Person extends Thread {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getPersonName() {
		return name;
	}
	
	public int getPersonAge() {
		return age;
	}
}
