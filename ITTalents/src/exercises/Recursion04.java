package exercises;

public class Recursion04 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println(arrAvgR(arr, 0, 0));
	}

	static double arrAvgR(int[] arr, int i, double sum) {
		if (i == arr.length) {
			return sum / arr.length;
		}
		sum += arr[i];
		return arrAvgR(arr, i + 1, sum);
	}
}
