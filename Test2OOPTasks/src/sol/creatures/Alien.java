package sol.creatures;

import java.util.ArrayList;

import sol.Inhabitable;

public class Alien extends TravellingCreature {
	public Alien(String name, int age, String species, ArrayList<Inhabitable> inhabitableSpaceObjects) {
		super(name, age, species, inhabitableSpaceObjects);
	}

}
