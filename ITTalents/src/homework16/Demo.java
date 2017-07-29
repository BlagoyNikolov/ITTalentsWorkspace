package homework16;

public class Demo {
	public static void main(String[] args) {
		Person[] people = new Person[10];
		
		Person pesho = new Person("Pesho", 15, true);
		Person gosho = new Person("Gosho", 21, true);
		
		Student minka = new Student("Minka", 19, false, 5.2);
		Student blago = new Student("Blago", 19, true, 5.6);
		
		Employee deso = new Employee("Deso", 23, true, 22); //3500
		Employee veso = new Employee("Veso", 22, true, 7.5); //1200
		
		add(pesho, people);
		add(gosho, people);
		add(minka, people);
		add(blago, people);
		add(deso, people);
		add(veso, people);
		
		printInfo(people);
		printOvertime(people);
	}
	
	public static void printOvertime(Person[] people) {
		for (int i = 0; i < people.length; i++) {
			if(people[i] instanceof Employee) {
				Employee e = (Employee) people[i];
				System.out.println("Money owed to employee " + e.getName() + ": " + e.calculateOvertime(2));
			}
		}
	}
	
	public static void printInfo(Person[] people) {
		for (int i = 0; i < people.length; i++) {
			if (people[i] instanceof Student) {
				System.out.println(people[i].toString());
			} else if(people[i] instanceof Employee) { 
				System.out.println(people[i].toString());
			} else if (people[i] instanceof Person) {
				System.out.println(people[i].toString());
			}
		}
	}
	
	public static void add(Person p, Person[] people) {
		for (int i = 0; i < people.length; i++) {
			if (people[i] == null) {
				people[i] = p;
				break;
			}
		}
	}
}
