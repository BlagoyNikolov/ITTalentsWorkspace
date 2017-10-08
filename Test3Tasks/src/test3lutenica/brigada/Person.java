package test3lutenica.brigada;

public abstract class Person extends Thread {
	protected String name;
	protected int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPersonName() {
		return name;
	}
}
