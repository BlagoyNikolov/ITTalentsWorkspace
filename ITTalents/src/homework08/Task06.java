package homework08;

import java.util.Scanner;

public class Task06 {
	public static void main(String[] args) {
		sentenceManipulator(getWords());
	}

	public static String getWords() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter some words");
		String input = sc.nextLine();
		while (input.isEmpty()) {
			System.out.println("Enter a valid string pls:");
			input = sc.nextLine();
		}
		return input;
	}

	public static String[] sentenceManipulator(String input) {
		String[] words = input.split(" ");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
			System.out.print(words[i] + " ");
		}
		return words;
	}
}
