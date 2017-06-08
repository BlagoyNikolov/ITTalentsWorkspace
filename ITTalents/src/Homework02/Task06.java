package homework02;

import java.util.Scanner;

public class Task06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		
		if (number < 1) {
			System.out.println("Enter a number bigger than 1");
			number = sc.nextInt();
		}
		
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			sum += i;
		}
		System.out.print("The product of the numbers between 1 and " + number + " is: " + sum);
	}
}
