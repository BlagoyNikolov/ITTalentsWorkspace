package sol.creatures;

import java.util.ArrayList;

import sol.Inhabitable;

public final class Human extends TravellingCreature {
	public Human(String name, int age, String species, ArrayList<Inhabitable> inhabitableSpaceObjects) {
		super(name, age, species, inhabitableSpaceObjects);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
