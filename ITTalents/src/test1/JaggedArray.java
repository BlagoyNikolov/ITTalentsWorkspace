package test1;

import java.util.Arrays;

public class JaggedArray {
	public static void main(String[] args) {
		int[] array = { 7, 2, 6, 3, 8, 1, 6, 3, 5, 1, 6, 5 };
		System.out.println(Arrays.toString(array));
		boolean isJagged = false;
		for (int i = 1; i <= array.length - 2; i++) {
			if ((array[i - 1] < array[i] && array[i] > array[i + 1])
					|| (array[i - 1] > array[i] && array[i] < array[i + 1])) {
				isJagged = true;
			} else {
				isJagged = false;
			}
		}
		System.out.println(isJagged);
	}
}
