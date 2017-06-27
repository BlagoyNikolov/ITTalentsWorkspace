package homework09;

public class Task03 {
	public static void main(String[] args) {
		System.out.println(isPrimeI(7));
		System.out.println(isPrimeR(7, 2, true));
	}

	private static boolean isPrimeR(int n, int i, boolean flag) {
		if (i == n / 2) {
			return flag;
		}
		if (n % i == 0) {
			flag = false;
		}
		return isPrimeR(n, i + 1, flag);
	}
	
	private static boolean isPrimeI(int n) {
		boolean isPrime = true;
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
