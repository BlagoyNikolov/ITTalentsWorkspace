package homework01;
import java.util.Scanner;

public class Task14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st position X:");
		int firstX = sc.nextInt();
		if (firstX <= 0 || firstX > 8) {
			System.out.println("Invalid position, try again");
			firstX = sc.nextInt();
		}
		System.out.println("Enter 1st position Y:");
		int firstY = sc.nextInt();
		if (firstY <= 0 || firstY > 8) {
			System.out.println("Invalid position, try again");
			firstY = sc.nextInt();
		}
		System.out.println("Enter 2nd position X:");
		int secondX = sc.nextInt();
		if (secondX <= 0 || secondX > 8) {
			System.out.println("Invalid position, try again");
			secondX = sc.nextInt();
		}
		System.out.println("Enter 2nd position Y:");
		int secondY = sc.nextInt();
		if (secondY <= 0 || secondY > 8) {
			System.out.println("Invalid position, try again");
			secondY = sc.nextInt();
		}
		System.out.println("Coordinates of first position: " + firstX + ", " + firstY);
		System.out.println("Coordinates of second position: " + secondX + ", " + secondY);
		
		boolean firstBlack = false;
		boolean secondBlack = false;
		
		if ((firstX - secondX) % 2 == 0) {
			firstBlack = true;
		}
		if ((firstY - secondY) % 2 == 0) {
			secondBlack = true;
		}
//		if ((firstX + firstY) % 2 == 0) {
//			firstBlack = true;
//		}
//		if ((secondX + secondY) % 2 == 0) {
//			secondBlack = true;
//		}
		if (firstBlack && secondBlack) {
			System.out.println("equal");
		} else {
			System.out.println("not the same color");
		}
	}
}
