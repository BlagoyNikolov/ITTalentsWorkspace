package homework05;

import java.util.Scanner;

public class Task06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first array length");
		int firstArraySize = sc.nextInt();

		int[] firstArray = new int[firstArraySize];
		for (int i = 0; i < firstArray.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			firstArray[i] = sc.nextInt();
		}
		
		System.out.println("Enter second array length");
		int secondArraySize = sc.nextInt();

		int[] secondArray = new int[secondArraySize];
		for (int i = 0; i < secondArray.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			secondArray[i] = sc.nextInt();
		}
		
		boolean areEqual = true;
		if (firstArray.length != secondArray.length) {
			areEqual = false;
		} else {
			for (int i = 0; i < firstArray.length; i++) {
				if (firstArray[i] != secondArray[i]) {
					areEqual = false;
				}
			}
		}
		System.out.println("Are the arrays equal? " + areEqual);
	}
}
