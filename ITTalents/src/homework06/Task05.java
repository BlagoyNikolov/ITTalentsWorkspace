package homework06;

public class Task05 {
	public static void main(String[] args) {
		int[] arr = convertToArray(12578);
		int[] newArr = new int[arr.length];

		System.out.println(palindromeR(arr, 0, true, newArr));
	}

	private static boolean palindromeR(int[] arr, int i, boolean flag, int[] newArr) {
		newArr[arr.length - 1 - i] = arr[i];
		if (i == arr.length - 1) {
			for (int j = 0; j < newArr.length; j++) {
				System.out.print(newArr[j]);
			}
			System.out.print(" ");
			return flag;
		}
		if (arr[i] != arr[arr.length - 1 - i]) {
			flag = false;
		}
		return palindromeR(arr, i + 1, flag, newArr);
	}

	public static int[] convertToArray(int n) {
		String temp = Integer.toString(n);
		int[] array = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			array[i] = temp.charAt(i) - '0';
		}
		return array;
	}
}
