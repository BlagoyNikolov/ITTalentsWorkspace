package lesson04EX;

import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		System.out.println("Enter a number to check if it is a prime number:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close(); 
		
		int counter = 2;
		boolean isPrime = true;
		while(counter < number / 2) {
			if (number % counter == 0) {
				System.out.print(counter + " ");
				isPrime = false;
				break;
			}
			counter++;
		}
		System.out.println("Is " + number + " prime? " + isPrime);
	}
}
