package homework28;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class LetterCounter {
	public static final String TEXT = "His name is Slim Shady";
	public static final String TEXTNOSPACES = TEXT.replaceAll("\\s+","");

	public static void main(String[] args) {

		Map<Character, Integer> dict = letterOccurences(TEXT);
		Set<Map.Entry<Character, Integer>> s = valueIterator(dict);
		for (Entry<Character, Integer> entry : s) {
			System.out.print(entry.getKey() +": " + entry.getValue() + " ");
			int percent = 100 * entry.getValue() / TEXTNOSPACES.length();
			for (int i = 0; i < percent; i++) {
				System.out.print("#");
			}
			System.out.println(" (" + percent + "%)");
		}
		//System.out.println(entriesSortedByValues(dict));
		
	}

	private static <T> Map<Character, Integer> letterOccurences(String input) {
		String text = input.toUpperCase();
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < text.length(); i++) {
			int counter = 0;
			char letter = text.charAt(i);
			if (letter != ' ') {
				for (int j = 0; j < text.length(); j++) {
					if (letter == text.charAt(j)) {
						counter++;
					}
				}
				map.put(letter, counter);
				counter = 0;
			} else {
				continue;
			}
		}
		return map;
	}

	private static Set<Entry<Character, Integer>> valueIterator(Map<Character, Integer> map) {
		Set set = new TreeSet(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				if (o1.getValue().compareTo(o2.getValue()) == 0) {
					return o1.getKey() - o2.getKey();
				}
				return o1.getValue().compareTo(o2.getValue()) < 0 ? 1 : -1;
			}
		});
		set.addAll(map.entrySet());
		return set/*.iterator()*/;
	}
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override 
	            public int compare(Map.Entry<K,V> o1, Map.Entry<K,V> o2) {
					return o1.getValue().compareTo(o2.getValue()) < 0 ? 1 : -1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
}
