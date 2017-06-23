package homework05;

import java.util.Scanner;

public class Task08 {
	public static void main(String[] args) {
		System.out.println(isWordPalindrome(getWord()));
	}
	
	public static String getWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word");
		String input = sc.next();
		while (input.contains(" ") || input.isEmpty()) {
			System.out.println("Enter a valid string pls:");
			input = sc.nextLine();
		}
		return input;
	}
	
	public static boolean isWordPalindrome(String word) {
		boolean isPalindrome = true;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}
}
