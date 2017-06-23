package homework06;

public class Task02 {
	public static void main(String[] args) {
		System.out.println(multyR(4, 6));
	}

	private static int multyR(int x, int y) {
		if (x == 1) {
			return y;
		}
		return y + multyR(x - 1, y);
	}
}
