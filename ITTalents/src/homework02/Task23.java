package homework02;

public class Task23 {
	public static void main(String[] args) {
		int counter = 1;
		int number = 1;
		while (counter <= 9) {
			while(number <= 9) {
				if (number >= counter) {
					System.out.print(counter + "*" + number + " ");
					number++;
				} else {
					number++;
				}
			}
			number = 1;
			System.out.println();
			counter++;
		}
	}
}
