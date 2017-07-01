package exercises;

public class BookRecursion {
	public static void main(String[] args) {
		int[] arr = { 5, 6, 9, 2, 7, 9 };
		int[] arr2 = { 5, 6, 7, 8, 9 };
		System.out.println(fact(6));
		System.out.println(minArr(arr, arr[0], 0));
		System.out.println(isMono(arr2, 1, false));
		System.out.println(hasDuplicates(arr, 0, false));
		System.out.println(getMaxIndex(arr, 0, 0));
		System.out.println(reverseI(1234567));
		System.out.println(reverseR(1234568));
		printTriangle(1, 6, 0);
		System.out.println(isPrime(108, false, 2));
		System.out.println(multy(7, 3));
		System.out.println(powery(2, 6));
	}

	static int fact(int n) {
		if (n == 1) {
			return 1;
		}
		return n * fact(n - 1);
	}

	static int minArr(int[] arr, int min, int i) {
		if (i == arr.length) {
			return min;
		}
		if (arr[i] < min) {
			min = arr[i];
		}
		return minArr(arr, min, i + 1);
	}

	static boolean isMono(int[] arr, int i, boolean flag) {
		if (i == arr.length) {
			return flag;
		}
		if (arr[i - 1] < arr[i]) {
			flag = true;
		} else {
			flag = false;
		}
		return isMono(arr, i + 1, flag);
	}

	static boolean hasDuplicates(int[] arr, int i, boolean flag) {
		if (i == arr.length) {
			return flag;
		}
		int counter = 0;
		int number = arr[i];
		for (int j = 0; j < arr.length; j++) {
			if (number == arr[j]) {
				counter++;
				if (counter > 1) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		if (flag) {
			return flag;
		}
		return hasDuplicates(arr, i + 1, flag);
	}

	static int getMaxIndex(int[] arr, int i, int maxIndex) {
		if (i == arr.length) {
			return maxIndex;
		}
		if (arr[maxIndex] < arr[i]) {
			maxIndex = i;
		}
		return getMaxIndex(arr, i + 1, maxIndex);
	}
	
	static int reverseI(int n) {
		int temp = n;
		int length = 0;
		int result = 0;
		while (temp > 0) {
			temp /= 10;
			length++;
		}
		int mnojitel = (int) Math.pow(10, (length - 1));
		while (n > 0) {
			int remainder = n % 10;
			n /= 10;
			result += mnojitel * remainder;
			mnojitel /= 10;
		}
		return result;
	}
	
	static int reverseR(int n) {
		int temp = n;
		int length = 0;
		int result = 0;
		while (temp > 0) {
			temp /= 10;
			length++;
		}
		int mnojitel = (int) Math.pow(10, (length - 1));
		return recR(n, result, mnojitel);
	}
	
	static int recR(int n, int result, int mnojitel) {
		if (n == 0) {
			return result;
		}
		int remainder = n % 10;
		result += mnojitel * remainder;
		return recR(n / 10, result, mnojitel / 10);
	}
	
	static void printTriangle(int start, int end, int index) {
		for (int j = start; j <= index; j++) {
			System.out.print(j + " ");
		}
		System.out.println();
		if (end != index) {
			printTriangle(start, end, index + 1);
		}
	}
	
	static boolean isPrime(int n, boolean flag, int index) {
		if (n == index) {
			return flag;
		}
		if (n % index == 0) {
			flag = false;
			return flag;
		} else {
			flag = true;
		}
		return isPrime(n, flag, index + 1);
	}
	
	static int multy(int x, int y) {
		if (x == 1) {
			return y;
		}
		return y + multy(x - 1, y);
	}
	
	static int powery(int x, int y) {
		int temp = multy(x, x);
		for (int i = 0; i < y - 2; i++) {
			temp = multy(temp, x);
		}
		return temp;
	}
}
