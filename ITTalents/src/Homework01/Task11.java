package homework01;

import java.util.Scanner;

public class Task11 {
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
		
		if (firstDigit == 0 || secondDigit == 0 || thirdDigit == 0) {
			System.out.println("Invalid number, cannot contain 0, try again:");
			number = sc.nextInt();
		}
		
		if (number < 100 || number > 999) {
			System.out.println("Invalid number try again: [100.. 999]");
			number = sc.nextInt();
		}

		if (number % firstDigit == 0 && number % secondDigit == 0 && number % thirdDigit == 0) {
			System.out.println("The number can be divided by EVERY digit it is made of");
		} else {
			System.out.println("The number cannot be divided by every digit it is made of");
		}
	}
}
