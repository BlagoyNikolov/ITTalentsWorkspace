package homework03;

import java.util.Scanner;

public class Task17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number: [3..20]");
		int number = sc.nextInt();
		while (number < 3 || number > 20) {
			System.out.println("Invalid number, try again: [3..20]");
			number = sc.nextInt();
		}
		System.out.println("Enter desired character:");
		char c = sc.next().charAt(0);
		sc.close();
		
		for (int i = 0; i < number; i++) {
			if (i == 0 || i == number - 1) {
				for (int j = 0; j < number; j++) {
					System.out.print("*");
				}
			} else {
				System.out.print("*");
				for (int j = 0; j < number - 2; j++) {
					System.out.print(c);
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
