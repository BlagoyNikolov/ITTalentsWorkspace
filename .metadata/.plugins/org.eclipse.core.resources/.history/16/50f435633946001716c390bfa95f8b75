import java.util.Scanner;

public class Task12 {
	public static void main(String[] args) {
		System.out.println("Enter day:");
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt(); // ??
		if (day <= 0 || day > 31) {
			System.out.println("Invalid day, try again");
			day = sc.nextInt();
		}

		System.out.println("Enter month:");
		int month = sc.nextInt();
		if (month <= 0 || month > 12) {
			System.out.println("Invalid month, try again");
			month = sc.nextInt();
		}

		System.out.println("Enter year:");
		int year = sc.nextInt();
		if (year <= 0 || year > 9999) {
			System.out.println("Invalid year, try again");
			year = sc.nextInt();
		}

		System.out.println("The current date is: " + day + "." + month + "." + year);
		boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) && day <= 31) {
			if (day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
		} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) {
			if (day == 30) {
				month++;
				day = 1;
			} else {
				day++;
			}
		} else if (month == 12 && day == 31) {
			year++;
			day = 1;
			month = 1;
		}  else if (isLeapYear) {
			if (day == 29 && month == 2) {
				month++;
				day = 1;
			} else {
				day++;
			}
		} else if (month == 2 && day <= 28) {
			if (day == 28) {
				month++;
				day = 1;
			} else {
				day++;
			}
		} else {
			System.out.println("The date you've entered is not valid!");
		}

		System.out.println("The date tommorow will be: " + day + "." + month + "." + year);
	}
}
