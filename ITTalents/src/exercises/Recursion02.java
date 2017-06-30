package exercises;

import java.util.Scanner;

public class Recursion02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// printR(-10, 10);
		// unevenR(1, 40);
		// System.out.println(sumR(10));
		// System.out.println(isPrimeR(16, 2, true));
		// printMatrix(1, 5, 5);
		// printTriangle(1, 6, 1);
		int[] arr = { 2, 3, 5, 1, 4, 3, 5, 8, 6 };
		findR(arr, 0, arr[0], arr[0]);

	}

	static void printR(int start, int end) {
		if (start <= end) {
			System.out.print(start + " ");
			printR(start + 1, end);
		}
	}

	static void unevenR(int start, int end) {
		if (start <= end) {
			if (start % 2 != 0) {
				System.out.print(start + " ");
			}
			unevenR(start + 1, end);
		}
	}

	static int sumR(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sumR(n - 1);
	}

	static boolean isPrimeR(int n, int i, boolean flag) {
		if (n == i) {
			return flag;
		}
		if (n % i == 0) {
			flag = false;
		}
		return isPrimeR(n, i + 1, flag);
	}

	static void printMatrix(int i, int end, int q) {
		if (i - 1 == end) {
			return;
		}
		for (int j = 1; j <= q; j++) {
			System.out.print(i + "" + j + " ");
		}
		System.out.println();
		printMatrix(i + 1, end, q);
	}

	static void printTriangle(int start, int n, int i) {
		if (i - 1 != n) {
			for (int j = start; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			printTriangle(start, n, i + 1);
		}
	}

	static void findR(int[] arr, int i, int max, int min) {
		if (i == arr.length) {
			System.out.println(max + " " + min);
			return;
		}
		if (arr[i] < min) {
			min = arr[i];
		}
		if (arr[i] > max) {
			max = arr[i];
		}
		findR(arr, i + 1, max, min);
	}

}
