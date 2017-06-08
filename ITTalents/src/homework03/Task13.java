package homework03;

import java.util.Scanner;

public class Task13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a decimal integer:");
		int number = sc.nextInt();
		sc.close();

		int size = 0;
		int temp = number;
		while (temp > 0) {
			temp /= 2;
			size++;
		}

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[array.length - 1 - i] = number % 2;
			number /= 2;
		}
		
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.print("]");
	}
}
