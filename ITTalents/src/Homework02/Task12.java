package homework02;

public class Task12 {
	public static void main(String[] args) {	
		int hundreds = 0; 
		int tens = 0; 
		int ones = 0; 
		
		for (int i = 100; i < 1000; i++) {
			hundreds = i / 100; 
			tens = i / 10 % 10;
			ones = i % 10;

			if (hundreds == tens || tens == ones || ones == hundreds) {
				continue;
			} else {
				System.out.print(i + " ");
			}
		}
	}
}
