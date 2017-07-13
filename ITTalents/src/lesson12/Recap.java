package lesson12;

public class Recap {

	public static void main(String[] args) {
		String s = "koza";
		int x = 10;
		// System.out.println(x.equals(s));
		System.out.println(s.equals(x));
		String krava = "krava";
		
		fs(x, krava);
		System.out.println(x);
		System.out.println(krava);
		// f(5);
		
		System.out.println(s.isEmpty());
		System.out.println(s.equals(" "));
		System.out.println();
		
		System.out.println("*".equals('*'));
		
		String str = "123456";
		StringBuilder sb = new StringBuilder();
		recReverse(str, 0, sb);
		System.out.println(sb.toString());
	}
	
	static void recReverse(String str, int i, StringBuilder sb) {
		if (i == str.length()) {
			return;
		}
		sb.append(str.charAt(str.length() - 1 -i));
		recReverse(str, i + 1, sb);
	}

	static int f(int x) {
		if (x == 100) {
			System.out.println("end");
			return 1;
		}
		System.out.println(x);
		return f(x++ + 1);
	}
	
	static void fs(int x, String s) {
		x = x++;
		s = s.toUpperCase();
	}
}
