package homework01;

import java.util.Scanner;

public class Task15 {
	public static void main(String[] args) {
		System.out.println("Enter desired number: [0..24]");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		if (number < 0 || number > 24) {
			System.out.println("Invalid number try again: [0..24]");
			number = sc.nextInt();
		}
		
		if (number >= 4 && number < 9) {
			System.out.println("Good morning");
		}
		if (number >= 9 && number < 18) {
			System.out.println("Good day");
		}
		if (number >= 18 || number < 4) {
			System.out.println("Good evening");
		}
	}
}
