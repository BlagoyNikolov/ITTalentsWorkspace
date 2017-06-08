package lesson05;

import java.util.Arrays;

public class CopyArrays {
	public static void main(String[] args) {
		int[] originalArray = { 1, 3, 5, 6, 7, 8 };
		int[] newArray = new int[originalArray.length];

		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = originalArray[i];
		}
		System.out.print("[");
		for (int i = 0; i < newArray.length; i++) {
			if (i == newArray.length - 1) {
				System.out.print(newArray[i]);
			} else {
				System.out.print(newArray[i] + ", ");
			}
		}
		System.out.print("]\n");
	}
}
