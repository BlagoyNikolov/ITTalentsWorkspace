package sol;

import java.util.ArrayList;

import sol.creatures.Human;
import sol.creatures.TravellingCreature;
import sol.spaceObjects.Earth;
import sol.spaceObjects.Sun;
import sol.spaceObjects.TheMoon;

public class Demo {
	public static void main(String[] args) {
		ArrayList<ISatellite> satellitesOfTheSun = new ArrayList<ISatellite>();
		ArrayList<ISatellite>satellitesOfTheEarth = new ArrayList<ISatellite>();
		ArrayList<Inhabitable>inhabitableSpaceObjects = new ArrayList<Inhabitable>();
		ArrayList<TravellingCreature> travellers = new ArrayList<TravellingCreature>();
		Sun sun = new Sun("The sun", 695700, "star", 1300000, 6000, satellitesOfTheSun);
		Earth earth = new Earth("The earth", 6371, "planet", 13000, 25, sun, satellitesOfTheEarth);
		TheMoon moon = new TheMoon("The moon", 1737, "moon", 5000, -120, earth);
		satellitesOfTheSun.add(earth);
		satellitesOfTheEarth.add(moon);
		inhabitableSpaceObjects.add(earth);
		Human human = new Human("Pesho", 24, "Human", inhabitableSpaceObjects);
		travellers.add(human);
		earth.setTravellers(travellers);
		System.out.println(earth.getTravellers());
	}
}
