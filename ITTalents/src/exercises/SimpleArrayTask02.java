package exercises;

import java.util.Scanner;

public class SimpleArrayTask02 {
	public static void main(String[] args) {
		Scanner workersSc = new Scanner(System.in);
		Scanner salSc = new Scanner(System.in);
		String[] workers = new String[5];
		double[] salaries = new double[5];
		for (int i = 0; i < workers.length; i++) {
			System.out.println("Enter worker " + (i + 1) + " names:");
			workers[i] = workersSc.nextLine();
			System.out.println("Enter worker " + (i + 1) + " salary:");
			salaries[i] = salSc.nextDouble();
		}
		double highSal = salaries[0];
		double lowSal = salaries[0];
		int highIndex = 0;
		int lowIndex = 0;
		double sum = 0;
		for (int i = 0; i < salaries.length; i++) {
			if (salaries[i] < lowSal) {
				lowSal = salaries[i];
				lowIndex = i;
			}
			if (salaries[i] > highSal) {
				highSal = salaries[i];
				highIndex = i;
			}
			sum += salaries[i];
		}
		System.out.println("The lowest salary belongs to " + workers[lowIndex] + " and is " + salaries[lowIndex]);
		System.out.println("The highest salary belongs to " + workers[highIndex] + " and is " + salaries[highIndex]);
		System.out.println("The sum of all salaries is " + sum + " and the avg is " + sum / salaries.length);
	}
}
