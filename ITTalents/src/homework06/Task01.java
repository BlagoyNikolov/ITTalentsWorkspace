package homework06;

public class Task01 {
	public static void main(String[] args) {
		System.out.println(fibR(8));
	}

	public static int fibR(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		return fibR(n - 2) + fibR(n - 1);
	}
}
