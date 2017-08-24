package company;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Company {
	private String name;
	private HashMap<String, HashSet<Employee>> employees;

	public Company(String name) {
		this.name = name;
		this.employees = new HashMap<String, HashSet<Employee>>();
		this.employees.put("Logistics", new HashSet<>());
		this.employees.put("Management", new HashSet<>());
	}

	public void add(Employee e, String department) {
		for (HashSet<Employee> set : employees.values()) {
			if (set.contains(e)) {
				return;
			}
		}

		if (employees.containsKey(department)) {
			if (this.employees.get(department).add(e)) {
				System.out.println("Employee added successfully");
			} else {
				System.out.println("Employee already exists");
			}
		} else {
			System.out.println(department + " is an invalid department for this company");
		}
	}

	private void printEmployees(Comparator<Employee> comp) {
		for (Iterator<String> it = employees.keySet().iterator(); it.hasNext();) {
			String department = it.next();
			System.out.println("-----" + department + "-----");
			TreeSet<Employee> sorted = new TreeSet<Employee>(comp);
			HashSet<Employee> employeesInDepartment = this.employees.get(department);
			sorted.addAll(employeesInDepartment);
			for (Employee employee : sorted) {
				System.out.println(employee);
			}
		}
	}

	public void printEmpsByName() {
		System.out.println("Sorted By Name");
		this.printEmployees(new EmployeeComparatorByName());
	}

	public void printEmpsByAge() {
		System.out.println("Sorted By Age");
		this.printEmployees(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getAge() == o2.getAge()) {
					return o1.getId() - o2.getId();
				}
				return o1.getAge() - o2.getAge();
			}
		});
	}

	public void printEmpsBySalary() {
		System.out.println("Sorted By Salary");
		this.printEmployees(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getSalary() == o2.getSalary()) {
					return o1.getId() - o2.getId();
				}
				return Double.compare(o1.getSalary(), o2.getSalary());
			}
		});
	}

	public Map<String, HashSet<Employee>> getEmpsByDept() {
		return Collections.unmodifiableMap(this.employees);
	}
	

}
