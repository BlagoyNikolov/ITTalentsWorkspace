package homework03;

import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length");
		int size = sc.nextInt();

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}
		
		boolean isMirror = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != array[array.length - 1 - i]) {
				isMirror = false;
			}
		}
		System.out.println("Is the array a palindrome? " + isMirror);
	}
}
