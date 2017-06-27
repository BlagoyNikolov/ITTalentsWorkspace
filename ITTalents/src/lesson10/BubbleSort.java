package lesson10;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 8, 12, 1, 6 };
		bubbleSort(arr);
		print(arr);
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean hasSwaps = false;
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					hasSwaps = true;
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
			if (!hasSwaps) {
				break;
			}
		}
	}
}
