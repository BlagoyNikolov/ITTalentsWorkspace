package homework10;

public class SelectionSortOptimizedAndFixed {
	public static void main(String[] args) {
		// int[] arr = { 6, 4, 8, 5, 2, 11 };
		// int[] arr = { 8, 11, 6, 10, 5 };
		// int[] arr = { 9, 0, 1, 6, 2, 4 };
		// int[] arr = { 7, 1, 6, 2, 4 };
		int[] arr = { 7, 1, 6, 2, 9 };
		selectionSortOptimized(arr);
		print(arr);
	}

	private static void selectionSortOptimized(int[] arr) {
		// find min element
		// swap min element with first element
		for (int i = 0; i < arr.length / 2; i++) {
			int min = arr[i];
			int max = arr[i];
			int minIndex = i;
			int maxIndex = i;

			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
				if (arr[j] > max) {
					max = arr[j];
					maxIndex = j;
				}
			}
			// swap arr[minIndex] with arr[0]
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		
			if (i == maxIndex) {
				maxIndex = minIndex;
			}
				
			int temp2 = arr[maxIndex];
			arr[maxIndex] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp2;
		}
	}
	
	private static void print(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.print("]");
	}
}
