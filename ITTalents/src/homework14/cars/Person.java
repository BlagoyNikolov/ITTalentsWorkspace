package homework14.cars;

public class Person {
	String name;
	int age;
	double weight;
	long personalNumber;
	boolean isMale;
	Person[] friends;
	double money;
	Car car;
	
	public Person() {
		this.age = 0;
		this.weight = 4.0;
	}
	
	Person(String name, long personalNumber, boolean isMale) {
		this();
		this.name = name;
		this.personalNumber = personalNumber;
		this.isMale = isMale;
		friends = new Person[3];
	}
	
	void buyCar(Car car) {
		if (this.money >= car.price) {
			this.money -= car.price;
			this.car = car;
		} else {
			System.out.println("Not enough money");
		}
	}
	
	void eat() {
		System.out.println(name + " is eating");
	}
	
	void growUp() {
		age++;
	}
}
