package sol.creatures;

import java.util.ArrayList;

import sol.Inhabitable;

public abstract class TravellingCreature extends Creature {
	protected ArrayList<Inhabitable> inhabitableSpaceObjects;
	
	public TravellingCreature(String name, int age, String species, ArrayList<Inhabitable> inhabitableSpaceObjects) {
		super(name, age, species);
		this.inhabitableSpaceObjects = inhabitableSpaceObjects;
	}

}
