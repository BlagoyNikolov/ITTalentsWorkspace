package test2.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

import test2.documents.Document;
import test2.employees.Employee;
import test2.employees.Junior;
import test2.employees.Regular;
import test2.employees.Senior;

public class Company {
	private String name;
	//private HashSet<Department> departments;
	private TreeMap<String, Department> deps;
	private TreeSet<Document> allProcessed;
	private TreeSet<Employee> allemps;
	
	public Company(String name) {
		this.name = name;
		//this.departments = new HashSet<Department>();
		this.deps = new TreeMap<>();
		this.allProcessed = new TreeSet<>();
		this.allemps = new TreeSet<>();
//		this.departments.add(new Department("Accounting"));
//		this.departments.add(new Department("IT"));
//		this.departments.add(new Department("Accounting"));
//		this.departments.add(new Department("Management"));
//		this.departments.add(new Department("QA"));
	}
	
	public Employee getRandomEmployee() {
		int x = new Random().nextInt(this.deps.size());
		int i = 0;
		for (Iterator<Employee> iterator = this.allemps.iterator(); iterator.hasNext(); i++) {
			Employee e = iterator.next();
			if (i == x) {
				return e;
			}
		}
		return null;
	}
	
	public void hireEmployee(Employee e, String departmentName) {
		if (departmentExists(departmentName)) {
			Department d = getDepartment(departmentName);
			int x = new Random().nextInt(3);
			switch (x) {
			case 0:
				d.addEmployee((Junior)e);
				break;
			case 1:
				d.addEmployee((Regular)e);
				break;
			case 2:
				d.addEmployee((Senior)e);
				break;
			default:
				break;
			}
			d.addEmployee(e);
			
		} else {
			this.deps.put(departmentName, new Department("departmentName"));
			Department d = getDepartment(departmentName);
			if (e instanceof Senior) {
				d.setSenior((Senior) e);
				d.addEmployee(e);
			} else {
				d.addEmployee(e);
			}
		}
	}
	
	public boolean departmentExists(String depName) {
		for (Entry<String, Department> department : deps.entrySet()) {
			if (department.getKey().equals(depName)) {
				return true;
			}
		}
		return false;
	}
	
	public Department getDepartment(String depName){
		for (Entry<String, Department> department : deps.entrySet()) {
			if (department.getKey().equals(depName)) {
				return department.getValue();
			}
		}
		return null;
	}
	
	public void processDocument(Document d) {
		Department dep = getRandomDepartment();
		Employee e = dep.getRandomEmployee();
		e.processDocument(d);
		System.out.println(e.getName()+" has been given " + d.getTitle() + " to process");
		this.allProcessed.add(d);
	}
	
	public Department getRandomDepartment() {
		int x = new Random().nextInt(this.deps.size());
		int i = 0;
		for (Iterator<Department> iterator = this.deps.values().iterator(); iterator.hasNext(); i++) {
			Department d = iterator.next();
			if (i == x) {
				return d;
			}
		}
		return null;
	}
	
	public void printAllProcessed() {
		TreeSet<Document> ts = new TreeSet<>(new Comparator<Document>() {
			@Override
			public int compare(Document o1, Document o2) {
				return o1.getComplexity() - o2.getComplexity();
			}
		});
		ts.addAll(this.allProcessed);
		for (Document document : ts) {
			System.out.println(document);
		}
	}
	
	public void addAllEmps() {
		for (Department dept : deps.values()) {
			this.allemps.addAll(dept.getEmployees());
		}
	}
	
	public void printBestEmp() {
		int min = 0;
		int current = 0;
		Employee lucky = null;
		TreeSet<Employee> set = this.allemps;
		for (Employee employee : set) {
			current = employee.getInvalidDocsNumber();
			if (current < min) {
				min = current;
				lucky = employee;
			}
		}
		System.out.println("The best employee is " + lucky.getName());
	}
	
	public void printWorstDep() {
		int max = 0;
		int current = 0;
		Department worst = null;
		TreeMap<String, Department> map = this.deps;
		ArrayList<Department> deps = new ArrayList<>();
		deps.addAll(map.values());
		for (Department department : deps) {
			current = department.getAllWrongDocsForDepartment();
			if (current < max) {
				max = current;
				worst = department;
			}
		}
		System.out.println("The worst department is " + worst.getName() + " with " + max + " errors");
	}
	
	public void printThreeBest() {
		int min = 0;
		int current = 0;
		Employee lucky = null;
		TreeSet<Employee> set = this.allemps;
		TreeSet<Employee> ts = new TreeSet<>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getInvalidDocsNumber() - o2.getInvalidDocsNumber();
			}
		});
		ts.addAll(set);
		int i = 0;
		System.out.println("The best 3 employees are:");
		for (Employee employee : ts) {
			if (i == 3) {
				break;
			}
			System.out.println(employee.getName());
			employee.increaseSalary();
			i++;
		}
		
	}
	
	public void printCompanyAll() {
		printThreeBest();
		printWorstDep();
		printBestEmp();
	}
}
