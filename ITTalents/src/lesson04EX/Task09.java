package lesson04EX;

import java.util.Scanner;

public class Task09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();

		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number - i - 1; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < 2 * i - 1; j++) {
				if (i == number - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			if (i > 0) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
