package homework05;

import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		System.out.println(stringShifter(getWord()));
	}
	
	public static String stringShifter(String input) {
		int charCode = 0;
		char[] inputChars = input.toCharArray();
		for (int i = 0; i < input.length(); i++) {
			charCode = input.charAt(i) + 5;
			inputChars[i] = (char) charCode;
		}
		
		return new String(inputChars);
	}
	
	public static String getWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String input = sc.nextLine();
		while (input.contains(" ") || input.isEmpty()) {
			System.out.println("Enter a valid string pls:");
			input = sc.nextLine();
		}
		return input;
	}
}
