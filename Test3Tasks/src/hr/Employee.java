package hr;

public class Employee {
	int employeeId;
	String firstName;
	String lastName;
	String managerFirstName;
	String managerLastName;
	String departmentName;
	double salary;
	
	public Employee(int employeeId, String firstName, String lastName, double salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	public Employee(String firstName, String lastName, String departmentName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentName = departmentName;
		this.salary = salary;
	}

	public Employee(String firstName, String lastName, String managerFirstName, String managerLastName,
			String departmentName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", managerFirstName=" + managerFirstName
				+ ", managerLastName=" + managerLastName + ", departmentName=" + departmentName + ", salary=" + salary
				+ "]\n";
	}
}
