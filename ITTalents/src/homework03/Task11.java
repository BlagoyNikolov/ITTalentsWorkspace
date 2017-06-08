package homework03;

import java.util.Scanner;

public class Task11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[7];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}
		
		//int[] array = { -23, -55, 17, 75, 56, 105, 134 };
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 5 == 0 && array[i] > 5) {
				System.out.print(array[i] + " ");
			}
		}
	}
}
