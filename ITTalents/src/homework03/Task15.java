package homework03;

import java.util.Scanner;

public class Task15 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter array length");
		 int size = sc.nextInt();
		
		 double[] array = new double[size];
		 for (int i = 0; i < array.length; i++) {
		 System.out.println("Enter element at index [" + i + "]");
		 array[i] = sc.nextDouble();
		 }

		//find first 3 biggest numbers!
		//double[] array = { 7.13, 0.2, 4.9, 5.1, 6.34, 1.12 };
		double max1 = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max1 < array[i]) {
				max1 = array[i];
			}
		}
		double max2 = array[1];
		for (int i = 0; i < array.length; i++) {
			if (max2 < array[i] && array[i] < max1) {
				max2 = array[i];
			}
		}
		double max3 = array[2];
		for (int i = 0; i < array.length; i++) {
			if (max3 < array[i] && array[i] < max2) {
				max3 = array[i];
			}
		}
		System.out.println(max1 + " " + max2 + " " + max3);
	}
}
