package lesson16;

public class Person {

	protected String name;
	protected String nickname;
	protected int age;
	
	protected Person(String name){
		this.name = name;
		System.out.println("a person was born");
	}
	
	protected Person(String name, int age){
		this(name);
		this.age = age;
	}

	public void eat(){
		System.out.println(this.name + " is eating");
	}
	
//	public void kill(){
//		System.out.println("I KILL TOU!");
//	}
	
}
