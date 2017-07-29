package homework16;

public class Person {
	private String name;
	private int age;
	private boolean isMale;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setName(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}	
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("Invalid age");
		}
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, boolean isMale) {
		this.setName(name);
		this.setAge(age);
		this.setMale(isMale);
	}
	
	//equivalent to showPersonInfo() in the requirements
	public String toString() {
		return String.format("Person Name: %s, Age: %d, Male: %b", this.getName(), this.getAge(), this.isMale());
	}
}
