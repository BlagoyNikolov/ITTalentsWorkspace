package homework08;

import java.util.Scanner;

public class Task09 {
	public static void main(String[] args) {
		System.out.println("The sum is: " + numbersInStringSum(getWord()));
	}

	public static int numbersInStringSum(String input) {
		int sumOfNumbersInString = 0;

		String numbers = "";
		for (int i = 0; i < input.length(); i++) {
			char evalChar = input.charAt(i);
			if (evalChar == '-' && Character.isDigit(input.charAt(i + 1))) {
				numbers += ':';
				numbers += evalChar;
			} else if (Character.isDigit(evalChar)) {
				numbers += evalChar;
			} else {
				numbers += ':';
			}
		}
		String[] output = numbers.split("\\:", -1);
		for (int j = 0; j < output.length; j++) {
			System.out.print(output[j] + " ");
		}
		System.out.println();
		
		int[] intArray = new int[output.length];
		for (int i = 0; i < intArray.length; i++) {
			if (output[i].isEmpty()) {
				continue;
			}
			intArray[i] = Integer.parseInt(output[i].trim());
			sumOfNumbersInString += intArray[i];
		}

		return sumOfNumbersInString;
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
