package test1;

import java.util.Scanner;

public class DecToBin {
	public static void main(String[] args) {
		//decToBIn(getNumber());
		decToBInArr(getNumber());
	}

	static void decToBInArr(int n) {
		int counter = 0;
		int temp = n;
		while (n > 0) {
			n = n / 2;
			counter++;
		}
		int[] result = new int[counter];
		int index = 0;
		while (temp > 0) {
			int remainder = temp % 2;
			result[result.length - 1 - index] = remainder;
			index++;
			temp = temp / 2;
		}
		System.out.println(counter);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	
	static void decToBIn(int n) {
		int output = 0;
		int temp = 1;
		while (n > 0) {
			int remainder = n % 2;
			n = n / 2;
			output = output + remainder * temp;
			temp *= 10;
		}
		System.out.println(output);
	}
	
	static int getNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		return sc.nextInt();
	}
}
