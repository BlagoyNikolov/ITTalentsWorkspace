package lesson08;

public class Tasks {
	public static void main(String[] args) {
		System.out.println(sum(5));
		System.out.println(sumOfUneven(99));
		int[] array = new int[] { 1, 5, 8, 10 };
		System.out.println("Iterative find max" + maxElementOfArrayI(array));
		System.out.println("Recursive find max" + maxElementOfArrayR(new int[] { 1, 20, 18, 3 }, 0, array[0]));
		System.out.println("Addition " + multy(4, 6));
		System.out.println("Power " + power(3, 8));
	}

	public static int sum(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sum(n - 1);
	}

	public static int sumOfUneven(int n) {
		if (n == 1) {
			return 1;
		}
		if (n % 2 != 0) {
			return n + sumOfUneven(n - 2);
		} else {
			n = n - 1;
			return n + sumOfUneven(n - 2);
		}
	}

	public static int maxElementOfArrayR(int[] array, int index, int max) {
		if (index == array.length - 1) {
			return max;
		}
		if (max < array[index]) {
			max = array[index];
		}
		return maxElementOfArrayR(array, index + 1, max);
	}

	public static int maxElementOfArrayI(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i + 1]) {
				max = array[i + 1];
			}
		}
		return max;
	}

	public static int multy(int x, int y) { // 4 po 4
		if (x == 1) {
			return y;
		}
		return y + multy(x - 1, y);
	}

	public static int power(int p, int q) { // 4 na 3 ta
		//4 na 3ta = 4-2 puti umnoji 4x4 -> 4x4x4
		//p na qta = q-2 puti umnoji pxp
		int result = multy(p, p);
		for (int i = 0; i < q - 2; i++) {
			result = multy(result, p);
		}
		return result;
	}
}
