package exercises;

import java.util.Scanner;

public class SimpleArrayTask03 {
	public static void main(String[] args) {
		Scanner scSize = new Scanner(System.in);
		Scanner scDays = new Scanner(System.in);
		System.out.println("Enter month day number");
		int size = scSize.nextInt();
		double[] month = new double[size];

		for (int i = 0; i < month.length; i++) {
			System.out.println("Enter month " + (i + 1) + " day");
			month[i] = scDays.nextDouble();
		}
		double sumOfTemps = 0;
		for (int i = 0; i < month.length; i++) {
			sumOfTemps += month[i];
		}
		double average = sumOfTemps / month.length;
		
		int daysBelowAvgCounter = 0;
		int maxDaysBelowAvgCounter = 0;
		int coldDaysCounter = 0;
		int maxcoldDaysCounter = 0;

		for (int i = 0; i < month.length - 1; i++) {
			if (month[i] < average && month[i + 1] < average) {
				daysBelowAvgCounter++;
				if (daysBelowAvgCounter > maxDaysBelowAvgCounter) {
					maxDaysBelowAvgCounter = daysBelowAvgCounter;
				}
			}
			if (month[i] > month[i + 1]) {
				coldDaysCounter++;
				if (coldDaysCounter > maxcoldDaysCounter) {
					maxcoldDaysCounter = coldDaysCounter;
				}
			}
			daysBelowAvgCounter = 0;
			coldDaysCounter = 0;
		}
		System.out.println("average " + average);
		System.out.println("maxDaysBelowAvgCounter " + maxDaysBelowAvgCounter);
		System.out.println("maxcoldDaysCounter " + maxcoldDaysCounter);
	}
}
