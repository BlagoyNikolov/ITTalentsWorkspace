package homework05;

import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length");
		int size = sc.nextInt();
		
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}
		
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if ((array[i] % 3 == 0) && array[i] < min) {
				min = array[i];
			}
		}
		System.out.println(min);
	}
}
