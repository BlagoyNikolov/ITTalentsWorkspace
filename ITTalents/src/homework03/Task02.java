package homework03;

import java.util.Scanner;

public class Task02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length");
		int size = sc.nextInt();

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}

		//int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		int start = (array.length / 2);
		int helper = 0;
		if (array.length % 2 == 0) {
			helper++;
		}
		for (int i = start, k = start - helper; i < array.length; i++, k--) {
			array[i] = array[k];
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
