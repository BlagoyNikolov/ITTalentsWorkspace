package homework05;

import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int[] array = new int[7];
		 for (int i = 0; i < array.length; i++) {
		 System.out.println("Enter element at index [" + i + "]");
		 array[i] = sc.nextInt();
		 }

		//int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		double arrLength = array.length;
		double average = sum / arrLength;
		double currentMinDifference = 0;
		double minDifference = average - array[0];
		int closestNumber = 0;
		
		for (int i = 0; i < array.length; i++) {
			currentMinDifference = Math.abs(average - array[i]);
			if (minDifference > currentMinDifference) {
				minDifference = currentMinDifference;
				closestNumber = array[i];
			}
		}
		System.out.println("Avg is: " + average + " Closest number is: " + closestNumber);
	}
}
