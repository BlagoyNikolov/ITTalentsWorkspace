package lesson22;

public class Frog implements Comparable<Frog>{
	
	private String name;
	private int age;
	private double weight;
	
	public double getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	Frog(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Frog other) {
		if(this.name.compareTo(other.name) == 0){
			return (this.age - other.age)*-1;
		}
		return this.name.compareTo(other.name);
		
	}
	
	@Override
	public String toString() {
		return name+"("+age+")";
	}
}
