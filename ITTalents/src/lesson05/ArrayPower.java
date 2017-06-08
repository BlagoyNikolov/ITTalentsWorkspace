package lesson05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayPower {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter array size:");
		// int size = sc.nextInt();
		// int[] array = new int[size];
		//
		// for (int i = 0; i < array.length; i++) {
		// System.out.println("Enter number at index: [" + i + "]");
		// array[i] = sc.nextInt();
		// }
		// sc.close();
		//
		// for (int i = 0; i < array.length; i++) {
		// array[i] = (array[i] * array[i] * array[i]);
		// System.out.print(array[i] + " ");
		// }

		// int number = 125;
		// boolean isCubic = false;
		// for (int i = 0; i < number; i++) {
		// if (number == (i * i * i)) {
		// isCubic = true;
		// break;
		// }
		// }
		// System.out.println(isCubic);

		// true/false
		// int counter = 0;
		// Random random = new Random();
		// while (true) {
		// boolean first = random.nextBoolean();
		// boolean second = random.nextBoolean();
		// System.out.println(first + "|" + second);
		// if (first == true && second == true) {
		// counter++;
		// } else {
		// counter = 0;
		// }
		// if (counter == 7) {
		// System.out.println("Exit");
		// break;
		// }
		// }

		// zarove
		// Random r = new Random();
		// int tries = 0;
		// int counter = 0;
		// while (true) {
		// tries++;
		// int first = r.nextInt(6) + 1;
		// int second = r.nextInt(6) + 1;
		// System.out.println(first + "|" + second);
		// if (first == 6 && second == 6) {
		// counter++;
		// } else {
		// counter = 0;
		// }
		// if (counter == 3) {
		// System.out.println("Tries: " + tries);
		// break;
		// }
		// }

		// jagged
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
