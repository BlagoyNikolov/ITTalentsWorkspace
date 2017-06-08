package lesson04;

import java.util.Scanner;

public class Sticks {
	public static void main(String[] args) {
		System.out.println("Enter a number to make some sticks:");
		Scanner sc = new Scanner(System.in);
		// int number = sc.nextInt();
		int number = 5;

		for (int i = 0; i < number; i++) { // 5times
			for (int j = 0; j < number; j++) {
				if (j == 0 + i || j == number - 1 - i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				if (i == number / 2) {
					System.out.print("*");
				} else {
					if (j == number / 2) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
		for (int i = 0; i < number; i++) { // 5times
			for (int j = 0; j < number; j++) {
				if (j == 0 + i || j == number - 1 - i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
