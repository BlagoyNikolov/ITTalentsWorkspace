package lesson08;

public class ComparingStrings {

	public static void main(String[] args) {
		
		String s1 = new String("krava");
		String s2 = new String("Krava");
		System.out.println(s1.equalsIgnoreCase(s2));
	}
}
