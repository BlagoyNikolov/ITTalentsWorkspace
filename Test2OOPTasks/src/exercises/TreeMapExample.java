package exercises;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapExample {
	public static final String TEXT = "Test text word count words count test text";
	
	public static void main(String[] args) {
		Map<String, Integer> wordCount = createWordCount(TEXT);
		printWordCount(wordCount);
	}

	private static Map<String, Integer> createWordCount(String text) {
		Scanner sc = new Scanner(text);
		Map<String, Integer> words = new TreeMap<String, Integer>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		while (sc.hasNext()) {
			String word = sc.next();
			Integer count = words.get(word);
			if (count == null) {
				count = 0;
			}
			words.put(word, count + 1);
		}
		return words;
	}
	
	private static void printWordCount(Map<String, Integer> wordCount) {
		for (Map.Entry<String, Integer> wordEntry : wordCount.entrySet()) {
			System.out.println("Word: " + wordEntry.getKey() + " is seen: " + wordEntry.getValue() + " times");
		}
	}
}
