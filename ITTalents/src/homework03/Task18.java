package homework03;

import java.util.Scanner;

public class Task18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first array length");
		int firstSize = sc.nextInt();
		int[] firstArray = new int[firstSize];
		for (int i = 0; i < firstArray.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			firstArray[i] = sc.nextInt();
		}

		System.out.println("Enter second array length");
		int secondSize = sc.nextInt();
		int[] secondArray = new int[secondSize];
		for (int i = 0; i < secondArray.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			secondArray[i] = sc.nextInt();
		}

		// int[] firstArray = { 18, 19, 32, 1, 3, 4, 5, 6, 7, 8 };
		// int[] secondArray = { 1, 2, 3, 4, 5, 16, 17, 18, 27, 11 };
		int[] thirdArray = null;
		if (firstArray.length != secondArray.length) {
			System.out.println("Arrays do not have the same length");
		} else {
			thirdArray = new int[firstArray.length];
			for (int i = 0; i < firstArray.length; i++) {
				if (firstArray[i] < secondArray[i]) {
					thirdArray[i] = secondArray[i];
				} else {
					thirdArray[i] = firstArray[i];
				}
			}
		}

		if (thirdArray != null) {
			System.out.print("[");
			for (int i = 0; i < thirdArray.length; i++) {
				if (i == thirdArray.length - 1) {
					System.out.print(thirdArray[i]);
				} else {
					System.out.print(thirdArray[i] + ", ");
				}
			}
			System.out.print("]");
		}
	}
}
