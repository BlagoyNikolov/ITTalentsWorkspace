package homework03;

import java.util.Scanner;

public class Task16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] array = new double[10];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element at index [" + i + "]");
			array[i] = sc.nextInt();
		}

		// double[] array = { -1.12, -2.43, 3.1, 4.2, 0, 6.4, -7.5, 8.6, 9.1, -4
		// };
		for (int i = 0; i < array.length; i++) {
			if (array[i] < -0.231) {
				array[i] = ((i + 1) * (i + 1)) + 41.25;
			} else {
				array[i] = array[i] * (i + 1);
			}
		}

		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.print("]");
	}
}
