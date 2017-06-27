package homework05;

import java.util.Scanner;

public class Task09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length");
		int size = sc.nextInt();

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}

		int[] tempArray = new int[size];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array[array.length - 1 - i];
		}
		System.out.print("[");
		for (int i = 0; i < tempArray.length; i++) {
			if (i == tempArray.length - 1) {
				System.out.print(tempArray[i]);
			} else {
				System.out.print(tempArray[i] + ", ");
			}
		}
		System.out.print("]");
		
		//without the need of a new array
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;	
		}
		System.out.print("[");
		for (int i = 0; i < tempArray.length; i++) {
			if (i == tempArray.length - 1) {
				System.out.print(tempArray[i]);
			} else {
				System.out.print(tempArray[i] + ", ");
			}
		}
		System.out.print("]");
	}
}
