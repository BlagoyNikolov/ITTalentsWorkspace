package exercises;

import java.util.Arrays;

public class BookMethods {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 5, 1, 3, 2, 7, 2 };
		System.out.println(arrAvgR(arr, 0, 0));
		mothDays("ocober", 2008);
		System.out.println(canFormTriangle(4, 9, 5));
		char[] charr = { 'a', '2', '8', 'z', '&', '9', 'p', 'c', '@' };
		System.out.println(numberOfDigits(charr));
		System.out.println(Arrays.toString(fives()));
		System.out.println(Arrays.toString(smallest(arr, arr2)));
		System.out.println(Arrays.toString(sorted(arr, arr2)));
	}

	static double arrAvgR(int[] arr, int i, double sum) {
		if (i == arr.length) {
			return sum / arr.length;
		}
		sum += arr[i];
		return arrAvgR(arr, i + 1, sum);
	}

	static int mothDays(String month, int year) {
		if ((((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) && month.equals("february")) {
			System.out.println("The month of " + month + " has " + 29 + " days");
		} else {
			switch (month) {
			case "january":
			case "march":
			case "may":
			case "july":
			case "august":
			case "ocober":
			case "december":
				System.out.println("The month of " + month + " has " + 31 + " days");
				return 31;
			case "february":
				System.out.println("The month of " + month + " has " + 28 + " days");
				return 28;
			case "april":
			case "june":
			case "september":
			case "november":
				System.out.println("The month of " + month + " has " + 30 + " days");
				return 30;
			default:
				System.out.println("no such month");
				return 0;
			}
		}
		return 0;
	}

	static boolean canFormTriangle(int a, int b, int c) {
		if (a + b > c && a + c > b && b + c > a) {
			return true;
		}
		return false;
	}

	static int numberOfDigits(char[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				counter++;
			}
		}
		return counter;
	}

	static int[] fives() {
		int size = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0) {
				size++;
			}
		}
		int[] result = new int[size];
		int index = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0) {
				result[index] = i;
				index++;
			}
		}
		return result;
	}

	static int[] smallest(int[] first, int[] second) {
		int[] result = null;
		if (first.length == second.length) {
			result = new int[first.length];
			for (int i = 0; i < result.length; i++) {
				if (first[i] < second[i]) {
					result[i] = first[i];
				} else {
					result[i] = second[i];
				}
			}
		} else {
			System.out.println("array lengths are not the same");
		}
		return result;
	}

	static int[] sorted(int[] first, int[] second) {
		int[] result = new int[first.length + second.length];
		int index = 0;
		int indexA = 0;
		int indexB = 0;
		while (indexA < first.length && indexB < second.length) {
			if (first[indexA] < second[indexB]) {
				result[index] = first[indexA];
				indexA++;
			} else {
				result[index] = second[indexB];
				indexB++;
			}
			index++;
		}
		while (indexA < first.length) {
			result[index] = first[indexA];
			indexA++;
			index++;
		}
		while (indexB < second.length) {
			result[index] = second[indexB];
			indexB++;
			index++;
		}
		return result;
	}
}
