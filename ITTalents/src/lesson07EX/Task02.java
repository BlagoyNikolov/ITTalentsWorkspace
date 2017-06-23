package lesson07EX;

import java.util.Arrays;

public class Task02 {
	public static void main(String[] args) {
		//int[] array = { 7, 2, 6, 3, 8, 1, 6, 3, 5, 1, 6, 5 };
		int[] array = { 1, 7, 2, 6};
		System.out.println(Arrays.toString(array));
		boolean isJagged = false;
		for (int i = 1; i <= array.length - 2; i++) {
			if ((array[i - 1] < array[i] && array[i] > array[i + 1]) || (array[i - 1] > array[i] && array[i] < array[i + 1])) {
				isJagged = true;
			} else {
				isJagged = false;
			}
		}
		System.out.println(isJagged);
	}
}
