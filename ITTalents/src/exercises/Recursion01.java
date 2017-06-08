package exercises;

public class Recursion01 {
	// 1 1 2 3 5 8 13 21 34
	public static int metod(int x) {
		if (x == 1) {
			return 1;
		}
		System.out.println(x);
		return metod(x + 2);
	}

	private static int factorial(int number) {
		if (number == 1) {
			return 1;
		}
		if (number <= 0) {
			System.out.println("Invalid input");
			return 1;
		}
		return number * factorial(number - 1);
	}

	private static int sum(int[] array, int index) {
		if (index == -1) {
			return 0;
		}
		System.out.println("sum: " + "------" + array[index]);
		return array[index] + sum(array, index - 1);
	}

	private static int biggest(int[] array, int index, int max) {
		if (index == array.length) {
			return max;
		}
		if (max < array[index]) {
			max = array[index];
		}
		return biggest(array, index + 1, max);
	}

	public static void main(String[] args) {
		// metod(4);
		// System.out.println(factorial(-5));
		/*
		 * Да се състави програма, която изчислява N-тото число на Фибоначи.
		 * Първото и второто число на Фибоначи са 1-ци, всяко следващо е равно
		 * на сбора на предходните 2. Пример: 8 Изход: 21 Първите 5 числа на
		 * Фибоначи са : 1, 1,2, 3, 5, 8, 13, 21
		 */
		int[] array = { 512, 7, 789 };
		// System.out.println(sum(array, array.length - 1));
		System.out.println(biggest(array, 0, Integer.MIN_VALUE));
	}
}
