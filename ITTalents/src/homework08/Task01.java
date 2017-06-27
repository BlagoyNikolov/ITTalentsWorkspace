package homework08;

import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		String first = getString();
		String second = getString();
		stringManipulator(first, second);
	}
	
	public static String getString() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the contents of the string");
		String input = sc.nextLine();
		while (input.length() > 40) {
			System.out.println("String is too long, try with a shorter one. [40]");
			input = sc.nextLine();
		}
		return input;
	}
	
	public static void stringManipulator(String first, String second) {
		String firstToLower = first.toLowerCase();
		String secondToLower = second.toLowerCase();
		String firstToUpper = first.toUpperCase();
		String secondToUpper = second.toUpperCase();
		
		System.out.println(firstToLower + " " + firstToUpper + " " + secondToLower + " " + secondToUpper);
	}
}
