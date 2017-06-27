package homework02;

import java.util.Scanner;

public class Book05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first bool:");
		boolean first = sc.nextBoolean();
		System.out.println("Enter first bool:");
		boolean second = sc.nextBoolean();
		
		System.out.println(first & second);
		System.out.println(first | second);
		System.out.println(first ^ second);
	}
}
