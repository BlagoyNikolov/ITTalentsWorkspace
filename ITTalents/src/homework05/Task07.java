package homework05;

import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		wordCounter(getWords());
	}
	
	public static String getWords() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter some words");
		String input = sc.nextLine();
		while (input.contains(" ") || input.isEmpty()) {
			System.out.println("Enter a valid string pls:");
			input = sc.nextLine();
		}
		return input;
	}
	
	public static void wordCounter(String input) {
		String[] words = input.split(" ");
		int currentLongest = 0;
		int longest = 0;
		for (int i = 0; i < words.length; i++) {
			currentLongest = words[i].length();
			if (currentLongest > longest) {
				longest = currentLongest;
			}
			currentLongest = 0;
		}
		System.out.println(words.length + " words, the longest is " + longest + " chars long");
	}
}
