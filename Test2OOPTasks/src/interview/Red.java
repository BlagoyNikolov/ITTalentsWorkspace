package interview;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Red {
	public static void main(String[] args) {
		TreeMap<String, LocalTime> red = new TreeMap<>();
	
		addNames(red);
		printByOrder(red);
		//System.out.println(red);
	}

	private static void printByOrder(TreeMap<String, LocalTime> red) {
		Set<Entry<String, LocalTime>> entries = red.entrySet();
		for (Iterator<Entry<String, LocalTime>> iterator = entries.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

	private static void addNames(TreeMap<String, LocalTime> red) {
		LocalTime startingTime = LocalTime.of(9, 0);
		final String[] names = {
			"Антоний",
			"Благой",
			"Борис",
			"Веселина",
			"Георги",
			"Гроздан",
			"Денислав",
			"Димана",
			"Иван",
			"Илия",
			"Илонка",
			"Кристиян Кошничаров",
			"Кристиян Първанов",
			"Натали",
			"Райна",
			"Слави",
			"Таня",
		};
		int minutes = 0;
		for (int i = 0; i < names.length; i++) {
			red.put(names[i], startingTime.plusMinutes(minutes));
			minutes += 15;
		}
	}
}
