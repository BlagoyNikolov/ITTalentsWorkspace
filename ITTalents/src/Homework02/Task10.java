package homework02;

import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		
		int counter = 2;
		boolean isPrime = false;
		for (int i = counter; i < number; i++) {
			if (number % counter == 0) {
				isPrime = false;
				System.out.print(counter + " ");
				break;
			} else {
				isPrime = true;
			}
			counter++;
		}
		if (number == 2) {
			isPrime = true;
		}
		System.out.println("Is the number " + number + " prime? " + isPrime);
	}
}
