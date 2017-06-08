package homework03;

import java.util.Scanner;

public class Task08 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter array length");
		 int size = sc.nextInt();
		
		 int[] array = new int[size];
		 for (int i = 0; i < array.length; i++) {
		 System.out.println("Enter element at index [" + i + "]");
		 array[i] = sc.nextInt();
		 }

		//int[] array = { 1, 2, 2, 4, 3, 3, 3, 3, 3, 10, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 2, 1 };
		//int[] array = { 1, 2, 2, 3, 3, 3, 3, 3, 3, 10, 2, 2, 2 };
		
		int maxCount = 0;
		int currentCount = 0;
		int currentNumber = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) {
				currentCount++;
				if (currentCount > maxCount) {
					maxCount = currentCount;
					currentNumber = array[i];
				}
			} else {
				currentCount = 0;
			}
		}
		maxCount = maxCount + 1;
		System.out.println(maxCount);
		for (int i = 0; i < maxCount; i++) {
			System.out.print(currentNumber + " ");
		}
	}
}
