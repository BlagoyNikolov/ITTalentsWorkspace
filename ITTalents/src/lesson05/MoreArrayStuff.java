package lesson05;

import java.util.Scanner;

public class MoreArrayStuff {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		int size = sc.nextInt();
		int[] array = new int[size];
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter number at index: [" + i + "]");
			array[i] = sc.nextInt();
		}
		sc.close();
		
		int min = array[0];
		int max = array[0];
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}
			sum += array[i];
		}
		System.out.println("Min is " + min + " Max is " + max + " Avg is " + (sum/array.length));
	}
}
