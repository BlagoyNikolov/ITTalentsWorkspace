package homework01;

import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		System.out.println("Enter desired volume of water:");
		Scanner sc = new Scanner(System.in);
		int volume = sc.nextInt();
		
		if (volume < 10 || volume > 9999) {
			System.out.println("Invalid number try again: [10..9999]");
			volume = sc.nextInt();
		}
		
		int bothBuckets = volume / 5;
		System.out.println(bothBuckets + " x 2 liters");
		System.out.println(bothBuckets + " x 3 liters");
		
		if (volume % 5 == 2) {
			System.out.println("additional bucket of 2 liters");
		} else {
			System.out.println("additional bucket of 3 liters");
		}
		
	}
}
