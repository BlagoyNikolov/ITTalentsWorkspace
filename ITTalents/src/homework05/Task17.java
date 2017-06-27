package homework05;

import java.util.Scanner;

public class Task17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length");
		int size = sc.nextInt();

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}

		//int[] array = { 7, 2, 6, 3, 8, 1, 6, 3, 5, 1, 6, 5 };
		boolean isJagged = false;
		for (int i = 1; i <= array.length - 2; i++) {
			if ((array[i - 1] < array[i] && array[i] > array[i + 1])
					|| (array[i - 1] > array[i] && array[i] < array[i + 1])) {
				isJagged = true;
			} else {
				isJagged = false;
			}
		}
		System.out.println(isJagged);
	}
}
