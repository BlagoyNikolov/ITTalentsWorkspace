package Lesson20.nested;

public class Car {
	
	private String name;
	private Engine engine;
	
	Car(String name, int hp, int kubici){
		this.name = name;
		this.engine = new Engine(hp, kubici);
		this.engine.hp++;
	}

	void start(){
		this.engine.start();
	}
	
	//static nested class - independant from the outer class, can exist on its own
	//has access ot static private vars of outer class
	static class Engine{
		
		private int hp;
		private double volume;
		
		public Engine(int hp, double volume) {
			this.hp = hp;
			this.volume = volume;
		}
		
		private void start(){
			System.out.println("Engine started");
		}
		
	}
}
