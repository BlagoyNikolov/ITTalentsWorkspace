package homework02;
import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		System.out.println("Enter hour:");
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt(); // ??
		System.out.println("Enter money:");
		double balance = sc.nextDouble();
		System.out.println("Enter health state, true for healthy, false for sick:");
		boolean isHealthy = sc.nextBoolean();
		sc.close();
		
		if (!isHealthy) {
			System.out.println("I'll not go out today");
		}
		if (balance > 0 && !isHealthy) {
			System.out.println("I'll buy some drugs");
		} else if (balance < 0 && !isHealthy) {
			System.out.println("I'll stay home & drink some tea");
		}
		if (isHealthy) {
			System.out.println("I'll go out with friends");
		}
		if (isHealthy && balance > 0 && balance <= 10) {
			System.out.println("I'll go to a cafe");
		}
	}
}
