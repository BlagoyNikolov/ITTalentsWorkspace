package homework01;

import java.util.Scanner;

public class Task16 {
	public static void main(String[] args) {
		System.out.println("Enter desired 3 digit number:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		if (number < 100 || number > 999) {
			System.out.println("Invalid number try again: [100.. 999]");
			number = sc.nextInt();
		}

		int firstDigit = number / 100;
		int secondDigit = number / 10 % 10;
		int thirdDigit = number % 10;

		if (firstDigit == secondDigit && secondDigit == thirdDigit) {
			System.out.println("All digits are equal");
		} else if (firstDigit > secondDigit && secondDigit > thirdDigit) {
			System.out.println("Digits are in descending order");
		} else if (firstDigit < secondDigit && secondDigit < thirdDigit) {
			System.out.println("Digits are in ascending order");
		} else {
			System.out.println("No order in digit positioning");
		}
	}
}
