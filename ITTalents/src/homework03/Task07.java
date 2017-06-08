package homework03;

import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length");
		int size = sc.nextInt();

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}
		
		int[] newArray = new int[size];
		newArray[0] = array[0];
		newArray[array.length - 1] = array[array.length - 1];
		for (int i = 1; i < newArray.length - 1; i++) {
			newArray[i] = array[i - 1] + array[i + 1];
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
