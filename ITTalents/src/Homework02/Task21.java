package Homework02;

import java.util.Scanner;

public class Task21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number: [1..51]");
		int number = sc.nextInt();
		while (number < 1 || number > 51) {
			System.out.println("Invalid number, try again: [1..51]");
			number = sc.nextInt();
		}
		sc.close();

		number--;
		while (number <= 51) {
			int size = number / 4;
			switch (size) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				System.out.print(size + 2 + " ");
			case 9:
				System.out.print("Jack ");
				break;
			case 10:
				System.out.print("Queen ");
				break;
			case 11:
				System.out.print("King ");
				break;
			case 12:
				System.out.print("Ace ");
				break;
			default:
				System.out.println("Error");
			}

			int color = number % 4;
			switch (color) {
			case 0:
				System.out.print("spades, ");
				break;
			case 1:
				System.out.print("diamonds, ");
				break;
			case 2:
				System.out.print("hearts, ");
				break;
			case 3:
				System.out.print("clubs, ");
				break;
			}
			number++;
		}
	}
}
