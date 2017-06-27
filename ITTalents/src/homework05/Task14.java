package homework05;

import java.util.Scanner;

public class Task14 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter array length");
		 int size = sc.nextInt();
		
		 double[] array = new double[size];
		 for (int i = 0; i < array.length; i++) {
		 System.out.println("Enter element at index [" + i + "]");
		 array[i] = sc.nextDouble();
		 }

		//double[] array = { 7.1, 8.5, 0.2, 3.7, 0.99, 1.4, -3.5, -110, 212, 341, 1.2 };
		int newSize = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= -2.99 && array[i] <= 2.99) {
				newSize++;
			}
		}

		double[] newArray = new double[newSize];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (array[i] >= -2.99 && array[i] <= 2.99) {
				newArray[k] = array[i];
				k++;
			}
		}
		
		System.out.print("[");
		for (int i = 0; i < newArray.length; i++) {
			if (i == newArray.length - 1) {
				System.out.print(newArray[i]);
			} else {
				System.out.print(newArray[i] + ", ");
			}
		}
		System.out.print("]");
	}
}
