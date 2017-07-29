package lesson17.zoo;

public abstract class Animal implements Feedable{

	private String name;
	
	Animal(String name){
		this.name = name;
	}
	
	public void sleep(){
		System.out.println("sleeping");
	}
	
	abstract void makeNoise();
	
	void reactToSunBlock(){
	}
}
