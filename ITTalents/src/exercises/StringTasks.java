package exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class StringTasks {
	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		System.out.println("Is prefix? " + isPrefix("prefix", "prefixornot"));

		// System.out.println("Enter names:");
		printInitials(/* sc.nextLine() */ "Blagoy Lachezarov Nikolov");

		System.out.println("\nIs palindrome? " + isPalidrome("ailqkqlia"));

		String[] ebasiStringa = englishOcc("starwarstheforceawakens");
		for (int i = 0; i < ebasiStringa.length; i++) {
			System.out.println(ebasiStringa[i]);
		}

		System.out.println("Is anagram? " + isAnagram("silent", "listen"));

		String[] strArray = { "Blagoy", "Lachezarov", "Nikolov", "121213206" };
		System.out.println(concatenate(strArray));
		System.out.println(concatenateSB(strArray));

		double[][] matrix = { { 3.142, 2.563, 7.282 }, { 35.942, 17.512 } };
		System.out.println(matrixToSting(matrix));

		System.out.println(T9("44335556668443377733"));

		System.out.println(formNumber(19, 15));
	}

	public static boolean isPrefix(String subsStr, String string) {
		boolean isPrefix = false;

		if (string.startsWith(subsStr)) {
			isPrefix = true;
		}
		return isPrefix;
	}

	public static void printInitials(String str) {
		String[] names = str.split(" ");
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i].substring(0, 1));
		}
	}

	public static boolean isPalidrome(String string) {
		boolean isPalindrome = true;
		for (int i = 0; i < string.length() / 2; i++) {
			if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

	public static String[] englishOcc(String str) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String[] output = new String[26];
		int currentLetterCounter = 0;
		int maxLetterCounter = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			char currentLetter = alphabet.charAt(i);
			for (int j = 0; j < str.length(); j++) {
				if (currentLetter == str.charAt(j)) {
					currentLetterCounter++;
					if (currentLetterCounter > maxLetterCounter) {
						maxLetterCounter = currentLetterCounter;
					}
				}
			}

			output[i] = String.format("%c -> %d times", currentLetter, currentLetterCounter);
			currentLetterCounter = 0;
		}
		return output;
	}

	public static boolean isAnagram(String first, String second) { // ("silent","listen")
																	// ("andrew","wasned");
		int counter = 0;
		boolean isAnagram = false;
		for (int i = 0; i < first.length(); i++) {
			char letter = first.charAt(i);
			for (int j = 0; j < second.length(); j++) {
				if (letter == second.charAt(j)) {
					counter++;
					if (counter == 1) {
						isAnagram = true;
					} else {
						isAnagram = false;
						break;
					}
				}
			}
			if (!isAnagram) {
				break;
			}
			if (counter == 0) {
				isAnagram = false;
				break;
			}
			counter = 0;
		}
		return isAnagram;
	}

	public static String concatenate(String[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}

	public static String concatenateSB(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static String matrixToSting(double[][] matrix) {
		DecimalFormat df = new DecimalFormat("0.00");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sb.append(df.format(matrix[i][j]));
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static String T9(String input) { //44335556668443377733
		String[][] alphabet = { { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" }, { "J", "K", "L" },
				{ "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" }, { "X", "Y", "Z" } };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			int current = Character.getNumericValue(input.charAt(i));
			if (i > 0) {
				if (current == Character.getNumericValue(input.charAt(i - 1))) {
					break;
				}
			}
			
			for (int j = 0; j < alphabet.length; j++) {
				int counter = 0;
				if (input.charAt(j) == input.charAt(j + 1)) {
					counter++;
				}

				System.out.print(alphabet[current - 2][counter]);
				counter = 0;
			}
		}
		return sb.toString();
	}

	public static int formNumber(int n, int m) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
		System.out.println("index of " + m + ": ");
		return sb.indexOf(String.valueOf(m));
	}
}
