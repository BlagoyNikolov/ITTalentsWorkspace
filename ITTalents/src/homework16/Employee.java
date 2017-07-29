package homework16;

public class Employee extends Person {
	private double daySalary;
	
	public double getDaySalary() {
		return this.daySalary;
	}
	
	public void setDaySalary(double salary) {
		if (salary >= 0) {
			this.daySalary = salary;
		} else {
			System.out.println("Invalid salary");
		}
	}

	public Employee(String name, int age, boolean isMale, double salary) {
		super(name, age, isMale);
		this.setDaySalary(salary);
	}
	
	public double calculateOvertime(double hours) {
		if (this.getAge() < 18) {
			return 0;
		} else {
			return hours * (this.getDaySalary() * 1.5);
		}
	}
	
	//equivalent to showEmployeeInfo() in the requirements
	public String toString() {
		return String.format("Employee Name: %s, Age: %d, Male: %b, Salary (hour): %.2f", this.getName(), this.getAge(), this.isMale(), this.getDaySalary());
	}
}
