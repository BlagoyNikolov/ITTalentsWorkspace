package dwadsadwad2;

import java.util.Scanner;

public class Task11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		
		//filled triangle
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number - 1 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 1 + i * 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		//contoured triangle
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number - 1 - i; j++) {
				System.out.print(" ");
			}
			System.out.print("*");

			for (int j = 0; j < i * 2 - 1; j++) {
				if (i == number - 1) {
					for (int k = 0; k < i * 2 - 1; k++) {
						System.out.print("*");
					}
					break;
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
