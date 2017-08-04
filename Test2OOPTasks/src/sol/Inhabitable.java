package sol;

import java.util.ArrayList;

import sol.creatures.TravellingCreature;

public interface Inhabitable {
	public void buildHouse();
	public ArrayList<TravellingCreature> getTravellers();
}
