package test2.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import test2.employees.Employee;
import test2.employees.Junior;
import test2.employees.Regular;
import test2.employees.Senior;

public class Department {
	private Senior senior;
	private String name;
	private TreeSet<Employee> employees;
	private int wrongDocs;
	
	public Department(String name) {
		this.name = name;
		this.employees = new TreeSet<Employee>();
	}
	
	public void setSenior(Senior senior) {
		this.senior = senior;
	}
	
	public String getName() {
		return name;
	}
	
	public void addEmployee(Employee e) {
		this.employees.add(e);
	}
	
	public TreeSet<Employee> getEmployees() {
		return (TreeSet<Employee>) Collections.unmodifiableSet(employees);
	}
	
	public ArrayList<Junior> getJuniors() {
		ArrayList<Junior> juniors = new ArrayList<>();
		for (Employee e : employees) {
			if (e instanceof Junior) {
				juniors.add((Junior) e);
			}
		}
		return juniors;
	}
	
	public ArrayList<Regular> getRegulars() {
		ArrayList<Regular> regulars = new ArrayList<>();
		for (Employee e : employees) {
			if (e instanceof Regular) {
				regulars.add((Regular) e);
			}
		}
		return regulars;
	}
	
	public Junior getRandomJunior() {
		ArrayList<Junior> juns = this.getJuniors();
		int x = new Random().nextInt(juns.size()-1);
		return juns.get(x);
	}
	
	public Regular getRandomRegular() {
		ArrayList<Regular> regs = this.getRegulars();
		int x = new Random().nextInt(regs.size()-1);
		return regs.get(x);
	}
	
	public Employee getRandomEmployee() {
		int r = new Random().nextInt(employees.size());
		int i = 0;
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); i++) {
			Employee e = iterator.next();
			if (i == r) {
				return e;
			}
		}
		return null;
	}
	
	public void addEmployeeToDepartment(Employee e) {
		this.employees.add(e);
	}
	
	
	
	public void fireEmployee(Employee notlucky) {
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			if (employee.equals(notlucky)) {
				iterator.remove();
				System.out.println(notlucky.getName() + " fired with " + notlucky.getInvalidDocsNumber()  +"errors, soo sad");
			}
		}
	}
	
	public int getAllWrongDocsForDepartment() {
		int result = 0;
		for (Employee employee : employees) {
			result += employee.getInvalidDocsNumber();
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
}
