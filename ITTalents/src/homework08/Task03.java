package homework08;

import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		String first = getWord();
		String second = getWord();

		stringComparator(first, second);
	}

	private static void stringComparator(String first, String second) {
		if (first.length() == second.length()) {
			for (int i = 0; i < first.length(); i++) {
				if (first.charAt(i) != second.charAt(i)) {
					System.out.println((i + 1) + " " + first.charAt(i) + "-" + second.charAt(i));
				}
			}
		} else {
			System.out.println("Word lengths are not the same!");
		}

	}

	public static String getWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the contents of the word");
		String input = sc.next();
		while (input.contains(" ") || input.isEmpty()) {
			System.out.println("Enter a valid string pls:");
			input = sc.nextLine();
		}
		return input;
	}
}
