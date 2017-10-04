package helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;

import nataport.Dock;
import nataport.Storage;

public class Stuff {
	private HashSet<Storage> storages;
	private ArrayList<Queue<Dock>>docks;
	
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
				i++;
			}
		}
		return null;
	}
}
