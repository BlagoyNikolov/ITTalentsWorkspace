package homework08;

import java.util.Scanner;

public class RomanConvertor {
	public static void main(String[] args) {
		System.out.println(convert(getRoman()));
	}

	public static int convert(String roman) {
		String text = roman.toUpperCase();
		int number = 0;
		int oldNumber = 0;
		int sum = 0;
		for (int i = text.length() - 1; i >= 0; i--) {
			char currentSymbol = text.charAt(i);
			oldNumber = number;
			switch (currentSymbol) {
			case 'I':
				number = 1;
				break;
			case 'X':
				number = 10;
				break;
			case 'V':
				number = 5;
				break;
			case 'L':
				number = 50;
				break;
			case 'C':
				number = 100;
				break;
			case 'D':
				number = 500;
				break;
			case 'M':
				number = 1_000;
				break;
			}
			if (oldNumber > number) {
				sum -= number;
			} else {
				sum += number;
			}
		}
		return sum;
	}

	public static String getRoman() {
		System.out.println("Enter roman number");
		Scanner sc = new Scanner(System.in);
		String roman = sc.nextLine();
		while (!validRoman(roman)) {
			System.out.println("Invalid roman, try again");
			roman = sc.nextLine();
		}
		return roman;
	}

	public static boolean validRoman(String roman) {
		boolean isValid = true;
		String input = roman.toUpperCase();
		String numbers = "IVXLCDM";

		for (int i = 0; i < input.length(); i++) {
			if (!(input.contains(input.substring(i, i + 1)))) {
				isValid = false;
			}
		}

		return isValid;
	}
}
