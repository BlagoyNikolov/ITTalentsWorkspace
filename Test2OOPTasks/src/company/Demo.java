package company;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		Company c = new Company("IT Talents");
		Employee e1 = new Employee("Simo", 19, 900);
		Employee e2 = new Employee("Desi", 21, 1100);
		Employee e3 = new Employee("Ivan", 31, 1050);
		Employee e4 = new Employee("Pesho", 31, 1000);
		Employee e5 = new Employee("Zaprqn", 44, 1300);
		Employee e6 = new Employee("Stavri", 59, 1400);
		Employee e7 = new Employee("Stavri", 59, 1900);
		
		c.add(e1, "Logistics");
		c.add(e2, "Logistics");
		c.add(e5, "Logistics");
		c.add(e3, "Management");
		c.add(e4, "Management");
		c.add(e6, "Management");
		c.add(e7, "Management");
		
		c.printEmpsByAge();
		c.printEmpsByName();
		c.printEmpsBySalary();
		
		TreeSet<Employee> allEmps = getAllEmployees(c.getEmpsByDept());
		System.out.println("--------");
		for (Employee employee : allEmps) {
			System.out.println(employee);
		}
		
		TreeSet<Employee> uniqueEmps = removeDuplicateEmployees(allEmps);
		System.out.println("--------");
		for (Employee employee : uniqueEmps) {
			System.out.println(employee);
		}
	}
	
	public static TreeSet<Employee> getAllEmployees(Map<String, HashSet<Employee>> employeeByDepartment) {
		TreeSet<Employee> emps = new TreeSet<Employee>(new EmployeeComparatorByName());
		for(HashSet<Employee> set : employeeByDepartment.values()) {
			emps.addAll(set);
		}
		return emps;
	}
	
	public static TreeSet<Employee> removeDuplicateEmployees (TreeSet<Employee> allEmployees) {
		TreeSet<Employee> uniqueEmps = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getName().equals(o2.getName())) {
					return o1.getAge() - o2.getAge();
				}
				return o1.getName().compareTo(o2.getName());
			}
		});
		uniqueEmps.addAll(allEmployees);
		return uniqueEmps;
	}
}
