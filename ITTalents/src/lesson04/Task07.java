package lesson04;

import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		int first = sc.nextInt();
		System.out.println("Enter second number:");
		short second = sc.nextShort();
		while (second > 7 || second < 0) {
			System.out.println("The number must be < 7!");
			second = sc.nextShort();
		}
		System.out.println("Enter third number:");
		short third = sc.nextShort();
		while (third > 7 || third < 0) {
			System.out.println("The number must be < 7!");
			third = sc.nextShort();
		}
		sc.close();
		
		first = first ^ (1 << second);
		first = first ^ (1 << third);
		System.out.println(first);
	}
}
