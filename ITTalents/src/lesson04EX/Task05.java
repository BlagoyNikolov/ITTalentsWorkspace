package lesson04EX;

import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		int output = 0;
		int temp = 1;
		while (number > 0) {
			int remainder = number % 2;
			number = number / 2;	
			output = output + remainder * temp;
			temp *= 10;
		}
		System.out.println(output);
	}
}
