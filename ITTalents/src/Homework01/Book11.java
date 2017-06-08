package homework01;

import java.util.Scanner;

public class Book11 {
	public static void main(String[] args) {
		System.out.println(6 & 4);
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int output = 0;
		//System.out.print(number % 2);
		output = output * 10 + (number % 2);
		number /= 2;
		//System.out.print(number % 2);
		output = output * 10 + (number % 2);
		number /= 2;
		//System.out.print(number % 2);
		output = output * 10 + (number % 2);
		number /= 2;
		//System.out.print(number % 2);
		output = output * 10 + (number % 2);
		number /= 2;
		//System.out.print(number % 2);
		output = output * 10 + (number % 2);
		number /= 2;
		//System.out.print(number % 2);
		output = output * 10 + (number % 2);
		number /= 2;
		System.out.println(output);
		
		System.out.println(~10);
	}
}
