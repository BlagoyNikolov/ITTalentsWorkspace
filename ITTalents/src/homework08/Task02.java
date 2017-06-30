package homework08;

import java.util.Scanner;

public class Task02 {
	public static void main(String[] args) {
		String first = getString();
		String second = getString();

		stringModifier(first, second);
	}
	
	public static String getString() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the contents of the string");
		String input = sc.nextLine();
		while (input.length() < 10 || input.length() > 20) {
			System.out.println("String is too long, try with a shorter one. [10..20]");
			input = sc.nextLine();
		}
		return input;
	}

	
	public static void stringModifier(String first, String second) {
		String firstStart = first.substring(0, 5);
		String secondStart = second.substring(0, 5);
		
//		String firstEnd = first.substring(5, first.length());
//		String secondEnd = second.substring(5, second.length());
//		
//		String newFirstString = secondStart + firstEnd;
//		String newSecondString = firstStart + secondEnd;
		
		first = first.replace(firstStart, secondStart);
		second = second.replace(secondStart, firstStart);
		
		System.out.println(first);
		System.out.println(second);
		
		if (first.length() > second.length()) {
			System.out.println(first + " length: " + first.length());
		} else {
			System.out.println(second + " length: " + second.length());
		}
	}
}
