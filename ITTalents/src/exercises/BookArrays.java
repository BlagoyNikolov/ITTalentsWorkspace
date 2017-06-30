package exercises;

import java.util.Arrays;

public class BookArrays {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 5, 4, 3, 2, 1 };
		int[] arr3 = { 7, 4, 2, 4, 17, 2, 6, 8, 8, 5, 4, 6, 7, 4, 20, 6 };
		char[] charr = {'b', 'A', 'Z', '2', '6', 'Z' };
		int[][] matrix = { {4, 7, 7, 2}, { 5, 7, 7, 2}, {1, 2, 7, 2}, {7, 7, 2, 6} };
		System.out.println(areEqualReverse(arr1, arr2));
		System.out.println(findMinMax(arr3));
		System.out.println(isAnyLowerCase(charr));
		System.out.println(findCommonInMatrix(matrix));
		int[] result = mergeArrays(arr1, arr2);
		System.out.println(Arrays.toString(result));
		int[][] resultMatrix = makeMatrix(3, 4);
		System.out.println(fibR(8));
	}

	private static boolean areEqualReverse(int[] arr1, int[] arr2) {
		boolean flag = true;
		if (arr1.length != arr2.length) {
			System.out.println("arrays are not equal");
			flag = false;
			return flag;
		} else {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[arr2.length - 1 - i]) {
					flag = false;
				}
			}
		}
		return flag;
	}

	private static String findMinMax(int[] arr3) {
		int max = arr3[0];
		int min = arr3[0];
		for (int i = 0; i < arr3.length; i++) {
			if (arr3[i] > max) {
				max = arr3[i];
			}
			if (arr3[i] < min) {
				min = arr3[i];
			}
		}
		return min + " " + max;
	}
	
	private static boolean isAnyLowerCase(char[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'a' && arr[i] <= 'z') {
				flag = true;
			}
		}
		return flag;
	}
	
	private static int findCommonInMatrix(int[][] arr) {
		int mostCommon = 0;
		int currentCounter = 0;
		int maxCounter = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int number = arr[i][j];
				for (int k = 0; k < arr.length; k++) {
					for (int l = 0; l < arr[k].length; l++) {
						if (number == arr[k][l]) {
							currentCounter++;
							if (currentCounter > maxCounter) {
								maxCounter = currentCounter;
								mostCommon = arr[k][l];
							}
						}
					}
					
				}
				currentCounter = 0;
			}
		}
		return mostCommon;
	}
	
	private static int[] mergeArrays(int[] first, int[] second) {
		int[] newArr = new int[first.length + second.length];
		for (int i = 0; i < first.length; i++) {
			newArr[i] = first[i];
		}
		for (int i = 0, j = second.length; j < newArr.length; i++, j++) {
			newArr[j] = second[i];
		}
		return newArr;
	}
	
	private static int[][] makeMatrix(int x, int y) {
		return new int[x][y];
	}
	
	private static int fibR(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibR(n - 2) + fibR(n - 1);
	}
}
