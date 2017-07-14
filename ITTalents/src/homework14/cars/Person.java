package homework14.cars;

public class Person {
	private String name;
	private int age;
	private double weight;
	private long personalNumber;
	private boolean isMale;
	private Person[] friends;
	private double money;
	private Car car;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("Invalid age");
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			System.out.println("Invalid weight");
		}
	}

	public long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(long personalNumber) {
		if (personalNumber > 0) {
			this.personalNumber = personalNumber;
		} else {
			System.out.println("Invalid personal number");
		}
		
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public Person[] getFriends() {
		return friends;
	}

	public void setFriends(Person[] friends) {
		if (friends != null) {
			this.friends = friends;
		} else {
			System.out.println("Invalid array of friends");
		}
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		if (money > 0) {
			this.money = money;
		} else {
			System.out.println("invalid money");
		}
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		if (car != null) {
			this.car = car;
		} else {
			System.out.println("Invalid array of cars");
		}
	}

	public Person() {
		this.setAge(0);
		this.setWeight(4.0);
	}
	
	Person(String name, long personalNumber, boolean isMale) {
		this();
		this.setName(name);
		this.setPersonalNumber(personalNumber);
		this.setMale(isMale);
		this.setFriends(new Person[3]);
	}
	
	void buyCar(Car car) {
		if (this.getMoney() >= car.getPrice()) {
			this.money -= car.getPrice();
			this.setCar(car);
		} else {
			System.out.println("Not enough money");
		}
	}
	
	double sellCarForScrap() {
		double scrapMoney = this.car.calculateCarPriceForScrap(0.5);
		this.money += scrapMoney;
		return this.money;
	}

	void eat() {
		System.out.println(name + " is eating");
	}
	
	void growUp() {
		age++;
	}
}
