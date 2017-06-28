package lesson08;

public class AddingStrings {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200_000; i++) {
			sb.append("K");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
