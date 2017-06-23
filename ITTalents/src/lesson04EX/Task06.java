package lesson04EX;

import java.util.Scanner;

public class Task06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		short number = sc.nextShort();
		sc.close();
		
		int counter = 0;
		while (number > 0) {
			if (number % 2 == 1) {
				counter++;
			}
			number = (short) (number / 2);	
		}
		System.out.println("The number of bits in the number is: " + counter);
	}
}
