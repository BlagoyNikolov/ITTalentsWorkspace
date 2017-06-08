package Homework02;

import java.util.Scanner;

public class Task18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired numbers: [1..9]");
		int firstNumber = sc.nextInt();
		while (firstNumber < 1 || firstNumber > 9) {
			System.out.println("Invalid number, try again: [1..9]");
			firstNumber = sc.nextInt();
		}
		int secondNumber = sc.nextInt();
		while (secondNumber < 1 || secondNumber > 9) {
			System.out.println("Invalid number, try again: [1..9]");
			secondNumber = sc.nextInt();
		}
		sc.close();
		
		for (int i = 1; i <= firstNumber; i++) {
			for (int j = 1; j <= secondNumber; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
	}
}
