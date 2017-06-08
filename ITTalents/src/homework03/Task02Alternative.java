package homework03;

import java.util.Scanner;

public class Task02Alternative {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length");
		int size = sc.nextInt();

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}
		
		//int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		
		int[] newArray = new int[array.length];
		int middle = (array.length / 2);
		int helper = 1;
		if (array.length % 2 != 0) {
			middle++;
			helper++;
		}
		for (int i = 0; i < middle; i++) {
			newArray[i] = array[i]; 
		}
		for (int i = middle, k = middle - helper; i < newArray.length; i++, k--) {
			newArray[i] = array[k];
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
