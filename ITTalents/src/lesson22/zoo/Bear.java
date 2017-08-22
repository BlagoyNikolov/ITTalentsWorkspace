package lesson22.zoo;

public class Bear /*implements Comparable*/ {
	private String name;
	private int age;
	private int furLength;
	
	public Bear(String name, int age, int furLength) {
		this.name = name;
		this.age = age;
		this.furLength = furLength;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getFurLength() {
		return furLength;
	}

	@Override
	public String toString() {
		return "Bear [name=" + name + ", age=" + age + ", furLength=" + furLength + "]";
	}

//	@Override
//	public int compareTo(Object o) {
//		Bear b = (Bear) o;
//		if (this.age == b.age) {
//			return this.furLength - b.furLength;
//		}
//		return this.age - b.age;
//	}
}
