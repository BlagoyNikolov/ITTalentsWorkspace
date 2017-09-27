package nataport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Pristanishte {
	//private HashSet<Dock> docks;
	private HashSet<Storage> storages;
	private ArrayList<Queue<Dock>>docks;

	public Pristanishte() {
		Dock.setPristanishte(this);

		docks = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			docks.add(new LinkedList<>());
		}
		storages = new HashSet<>();
		storages.add(new Storage());
		storages.add(new Storage());
	}

	public synchronized void getFromShip(Ship ship) {

	}

	public List<Queue<Dock>> getDocks() {
		return Collections.unmodifiableList(docks);
	}

	public Dock getDock(int x) {
		int i = 0;
		for (Iterator iterator = docks.iterator(); iterator.hasNext();) {
			Dock dock = (Dock) iterator.next();
			if (i == x) {
				return dock;
			}
			i++;
		}
		return null;
	}

	public Dock getRandomDock() {
		Random r = new Random();
		int index = r.nextInt(docks.size());
		int i = 0;
		for (Iterator iterator = docks.iterator(); iterator.hasNext();) {
			Queue<Dock> queue = (Queue<Dock>) iterator.next();
			for (Iterator iterator2 = queue.iterator(); iterator2.hasNext();) {
				Dock dock = (Dock) iterator2.next();
				if (index==i) {
					return dock;
				}
			}
		}
		return null;
	}

	public void raztovari(int time) {
		// TODO Auto-generated method stub
	}
}
