package Homework02;

import java.util.Scanner;

public class Task19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number: [10..99]");
		int number = sc.nextInt();
		while (number < 10 || number > 99) {
			System.out.println("Invalid number, try again: [10..99]");
			number = sc.nextInt();
		}
		sc.close();
		
		while (number > 1) {
			if (number % 2 == 0) {
				number = number / 2;
				System.out.print(number + " ");
			} else if (number % 2 != 0) {
				number = 3 * number + 1;
				System.out.print(number + " ");
			}
		}
	}
}
