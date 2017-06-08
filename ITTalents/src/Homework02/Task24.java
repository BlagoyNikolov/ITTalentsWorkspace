package Homework02;

import java.util.Scanner;

public class Task24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number to check if it is a palindrome: [10..30000]");
		int number = sc.nextInt();
		while (number < 10 || number > 30000) {
			System.out.println("Invalid number, try again: [10..30000]");
			number = sc.nextInt();
		}
		sc.close();
		
		int palindrome = number;
		int reverse = 0;
		do {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;
		} while (number != 0);
		if (reverse == palindrome) {
			System.out.println("The number is a palindrome");
		} else {
			System.out.println("The number is NOT a palindrome");
		}
	}
}
