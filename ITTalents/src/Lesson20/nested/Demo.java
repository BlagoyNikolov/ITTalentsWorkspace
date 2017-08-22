package Lesson20.nested;

import Lesson20.inner.Person;

public class Demo {

	public static void main(String[] args) {

		Car.Engine e = new Car.Engine(270, 3000);

		Person pesho = new Person();
		Person.Brain naPeshoMozuka = pesho.new Brain();
		naPeshoMozuka.sleep();
		
	}
}
