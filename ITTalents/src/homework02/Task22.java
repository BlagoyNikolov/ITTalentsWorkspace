package homework02;

import java.util.Scanner;

public class Task22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number: [1..999]");
		int number = sc.nextInt();
		while (number < 1 || number > 999) {
			System.out.println("Invalid number, try again: [1..999]");
			number = sc.nextInt();
		}
		sc.close();
		
		int counter = 1;
		while (counter <= 10) {
			number++;
			if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
				System.out.print(counter + ":" + number + " ");
				counter++;
			}
		}
	}
}
