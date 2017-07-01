package exercises;

public class Recursion03 {
	public static void main(String[] args) {
		// printRange(4, 10);
		// System.out.println();
		// threes(21, 1);
		// System.out.println();
		// System.out.println(isPalindrome(123321));
		// deletion(21, 1);
		// System.out.println(sumFact(3, 4));
		// rec(1, 7);
		// frameR(0, '8', 9);
		printTriangle(0, 5);

		int[] arr = { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 3 };
		findMostFrequent(arr);
	}

	static void printRange(int first, int second) {
		System.out.print(first + " ");
		if (first < second) {
			printRange(first + 1, second);
		}
	}

	static void threes(int x, int i) {
		if (i % 3 == 0) {
			System.out.print(i + " ");
		}
		if (i < x) {
			threes(x, i + 1);
		}
	}

	static void deletion(int x, int i) {
		if (x % i == 0) {
			System.out.print(i + " ");
		}
		if (i < x) {
			deletion(x, i + 1);
		}
	}

	static int factR(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factR(n - 1);
	}

	static int sumFact(int x, int y) {
		return factR(x) + factR(y);
	}

	static void rec(int counter, int number) {
		if (counter > 10) {
			return;
		}
		number++;
		if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
			System.out.print(counter + ":" + number + " ");
			counter++;
		}
		rec(counter, number);
	}

	static void frameR(int i, char ch, int n) {
		if (i == n) {
			return;
		}
		if (i == 0 || i == (n - 1)) {
			for (int j = 0; j < n; j++) {
				System.out.print('*');
			}
			System.out.println();
		} else {
			System.out.print('*');
			for (int j = 0; j < n - 2; j++) {
				System.out.print(ch);
			}
			System.out.print('*');
			System.out.println();
		}
		frameR(i + 1, ch, n);
	}

	static void printTriangle(int i, int n) {
		if (i == n) {
			return;
		}
		for (int j = n - 1 - i; j > 0; j--) {
			System.out.print(" ");
		}
		for (int j = 0; j < 1 + i * 2; j++) {
			System.out.print("*");
		}
		System.out.println();
		printTriangle(i + 1, n);
	}

	static boolean isPalindrome(int n) {
		int counter = 0;
		int temp = n;
		boolean flag = false;
		while (temp > 0) {
			temp /= 10;
			counter++;
		}
		System.out.println(counter);
		int big = (int) Math.pow(10, (counter - 1));
		int small = 10;
		while (big != small) {
			System.out.println(n / big % 10);
			System.out.println(n % small);
			if ((n / big) == (n % small)) {
				flag = true;
				big /= 10;
				small *= 10;
			}
		}
		return flag;
	}

	static void findMostFrequent(int[] arr) {
		int counter = 1;
		int max = 0;
		int mostF = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				counter++;
				if (counter > max) {
					max = counter;
					mostF = arr[i];
				}
			} else {
				counter = 1;
			}
		}
		for (int i = 0; i < max; i++) {
			System.out.print(mostF + " ");
		}
	}
}
