package homework09;

public class Task04 {
	public static void main(String[] args) {
		triangleR(1, 9, 1);
	}

	private static void triangleR(int start, int n, int i) {
		for (int j = start; j <= i; j++) {
			System.out.print(j + " ");
		}
		System.out.println();

		if (i != n) {
			triangleR(start, n, i + 1);
		}
	}
}
