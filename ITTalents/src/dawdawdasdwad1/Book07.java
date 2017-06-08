package dawdawdasdwad1;

import java.util.Scanner;

public class Book07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		int first = sc.nextInt();
		System.out.println("Enter first number:");
		int second = sc.nextInt();
		
		//3 5
		first = first + second; // 8
		second = first - second; // 8 - 5 = 3
		first = first - second; // 8 - 3 = 5
		System.out.println(first + " " + second);
	}
}
