package dwadsadwad2;

import java.util.Scanner;

public class Task13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired sum: [2..27]");
		int sum = sc.nextInt();
		while (sum < 2 || sum > 27) {
			System.out.println("Invalid number, try again: [2..27]");
			sum = sc.nextInt();
		}
		sc.close();
		
		int hundreds = 0; 
		int tens = 0; 
		int ones = 0; 
		
		for (int i = 100; i < 1000; i++) {
			hundreds = i / 100; 
			tens = i / 10 % 10;
			ones = i % 10;
			if ((hundreds + tens + ones) == sum) {
				System.out.print(i + " ");
			}
		}
	}
}
