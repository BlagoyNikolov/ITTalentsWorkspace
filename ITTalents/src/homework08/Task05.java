package homework08;

import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		String first = getWord();
		String second = getWord();
		crossPrinter(first, second);
	}

	public static void crossPrinter(String first, String second) {
		char crossPoint = 0;
		int counter = 0;
		boolean hasCrossPoint = false;
		for (int i = 0; i < first.length(); i++) {
			crossPoint = first.charAt(i);
			for (int j = 0; j < second.length(); j++) {
				if (crossPoint == second.charAt(j)) {
					counter = j;
					hasCrossPoint = true;
					break;
				}
			}
			if (hasCrossPoint) {
				break;
			}

		}
		System.out.println(hasCrossPoint + " " + crossPoint);

		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) == crossPoint) {
				for (int j = 0; j < second.length(); j++) {
					System.out.print(second.charAt(j));
				}
				System.out.println();
			} else {
				for (int j = 0; j < counter; j++) {
					System.out.print(" ");
				}
				System.out.println(first.charAt(i));
			}
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