package lesson13;

public class Person {

	String name;
	int age;
	Person friend;
	
	void eat(){
		System.out.println(name + " is eating!");
	}
	
	void growUp(){
		age++;
	}
}
