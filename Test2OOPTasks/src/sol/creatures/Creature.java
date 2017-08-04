package sol.creatures;

public abstract class Creature {
	protected String name;
	protected int age;
	protected String species;
	
	public Creature(String name, int age, String species) {
		this.name = name;
		this.age = age;
		this.species = species;
	}
	
	
}
