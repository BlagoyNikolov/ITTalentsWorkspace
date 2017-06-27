package homework08;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(findNFactorial(6));
	}
	
	public static int findNFactorial(int n) {
		int factorial = 1;
		if (n == 1) {
			return 1;
		}
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
}
