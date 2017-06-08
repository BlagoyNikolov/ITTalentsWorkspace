package homework03;

import java.util.Scanner;

public class Task12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[7];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}
		
		//int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int third = array[0];
		array[0] = array[1];
		array[1] = third;

		//3 and 4
		array[2] = array[2] + array[3]; // 3 + 4 = 7
		array[3] = array[2] - array[3]; // 7 - 4 = 3
		array[2] = array[2] - array[3]; // 7 - 3 = 4
		
		// 5 and 6
		array[4] = array[4] * array[5]; // 5 * 6 = 30
		array[5] = array[4] / array[5]; // 30 / 5 = 6
		array[4] = array[4] / array[5]; // 30 / 6 = 5
		
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
