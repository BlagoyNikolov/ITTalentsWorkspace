package Homework02;

import java.util.Scanner;

public class Task16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired numbers: [10..5555]");
		int firstNumber = sc.nextInt();
		while (firstNumber < 10 || firstNumber > 5555) {
			System.out.println("Invalid number, try again: [10..5555]");
			firstNumber = sc.nextInt();
		}
		int secondNumber = sc.nextInt();
		while (secondNumber < 10 || secondNumber > 5555) {
			System.out.println("Invalid number, try again: [10..5555]");
			secondNumber = sc.nextInt();
		}
		sc.close();

		if (firstNumber < secondNumber) {
			for (int i = secondNumber; i > firstNumber; i--) {
				if (i % 50 == 0) {
					System.out.print(i + " ");
				}
			}
		} else if (secondNumber < firstNumber) {
			for (int i = firstNumber; i > secondNumber; i--) {
				if (i % 50 == 0) {
					System.out.print(i + " ");
				}
			}
		}
	}
}
