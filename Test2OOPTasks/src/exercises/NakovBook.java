package exercises;

import java.time.LocalTime;
import java.util.*;

public class NakovBook {
	public static void main(String[] args) {
		removeElements();
		busSchedule();
	}
	
	private static void removeElements() {
		int[] array = new int[] { 4, 2, 2, 5, 2, 3, 2, 3, 1, 5, 2, 6, 6, 6 };
		List<Integer> list = new ArrayList<Integer>();
		
		Map<Integer, Integer> dict = countNumberOccurences(array);
		for (Iterator<Map.Entry<Integer, Integer>> iterator = dict.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, Integer> i = iterator.next();

			if (i.getValue() % 2 != 0) {
				iterator.remove();
			} else {
				list.add(i.getKey());
			}
		}
		System.out.println(dict);
		System.out.println(list);
	}
	
	private static Map<Integer, Integer> countNumberOccurences(int[] array) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int counter = 0;
			int number = array[i];
			for (int j = 0; j < array.length; j++) {
				if (number == array[j]) {
					counter++;
				}
			}
			hashMap.put(number, counter);
			counter = 0;
		}
		return hashMap;
	}

	private static void busSchedule() {
		TimeInterval t1 = new TimeInterval(LocalTime.of(8, 24), LocalTime.of(8, 33));
		TimeInterval t2 = new TimeInterval(LocalTime.of(8, 20), LocalTime.of(9, 0));
		TimeInterval t3 = new TimeInterval(LocalTime.of(8, 32), LocalTime.of(8, 37));
		TimeInterval t4 = new TimeInterval(LocalTime.of(9, 0), LocalTime.of(9, 15));
		TimeInterval desired = new TimeInterval(LocalTime.of(8, 22), LocalTime.of(9, 05));
		
		Set<TimeInterval> arrivalSorted = new TreeSet<TimeInterval>(new Comparator<TimeInterval>() {
			@Override
			public int compare(TimeInterval o1, TimeInterval o2) {
				if (o1.getArrival().getHour() == o2.getArrival().getHour()) {
					return o1.getArrival().getMinute() - o2.getArrival().getMinute();
				}
				return o1.getArrival().getHour() - o2.getArrival().getHour();
			}
		});
		arrivalSorted.add(t1);
		arrivalSorted.add(t2);
		arrivalSorted.add(t3);
		arrivalSorted.add(t4);
		System.out.println(arrivalSorted);
		
		for (Iterator iterator = arrivalSorted.iterator(); iterator.hasNext();) {
			TimeInterval timeInterval = (TimeInterval) iterator.next();
			if (timeInterval.getArrival().isBefore(desired.getArrival())) {
				iterator.remove();
			}
		}
		
		Set<TimeInterval> departureSorted = new TreeSet<TimeInterval>(new Comparator<TimeInterval>() {
			@Override
			public int compare(TimeInterval o1, TimeInterval o2) {
				if (o1.getDeparture().getHour() == o2.getDeparture().getHour()) {
					return o1.getDeparture().getMinute() - o2.getDeparture().getMinute();
				}
				return o1.getDeparture().getHour() - o2.getDeparture().getHour();
			}
		});
		departureSorted.add(t1);
		departureSorted.add(t2);
		departureSorted.add(t3);
		departureSorted.add(t4);
		System.out.println(departureSorted);
		
		for (Iterator iterator = departureSorted.iterator(); iterator.hasNext();) {
			TimeInterval timeInterval = (TimeInterval) iterator.next();
			if (timeInterval.getDeparture().isAfter(desired.getDeparture())) {
				iterator.remove();
			}
		}
		
		Set<TimeInterval> intersect = new HashSet<TimeInterval>(arrivalSorted);
		intersect.retainAll(departureSorted);
		
		System.out.println(intersect);
	}
}

