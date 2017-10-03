package test2.employees;

import java.util.TreeSet;

import test2.company.Department;
import test2.documents.Document;

public abstract class Employee {
	public enum EmployeeType {
		JUNIOR, REGULAR, SENIOR;
	}

	protected EmployeeType type;
	protected String name;
	protected double salary;
	protected int invalidDocsNumber;
	protected int processedDocs;
	protected int allDocs;
	protected TreeSet<Document> invalidDocuments;
	protected Department department;
	protected Document document;
	
	public Employee(EmployeeType type, String name, double salary) {
		this.type = type;
		this.name = name;
		this.salary = salary;
		this.invalidDocuments = new TreeSet<Document>();
	}
	
	public String getName() {
		return name;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public int getInvalidDocsNumber() {
		return invalidDocsNumber;
	}

	public TreeSet<Document> getInvalidDocuments() {
		return invalidDocuments;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setDocument(Document document) {
		this.document = document;
	}

	public void addInvalid() {
		this.invalidDocsNumber = invalidDocsNumber + 1;
	}

	public void addProcessed() {
		this.processedDocs = invalidDocsNumber + 1;
	}

	public void addToAllDocs() {
		this.allDocs = allDocs + 1;
	}

	public void addToInvalid(Document d) {
		this.invalidDocuments.add(d);
	}
	
	public abstract void processDocument(Document d);
	public abstract boolean calculateError(Document d);
	
	public void printEmployeeReport() {
		System.out.println("--" + this.name + " report---");
		System.out.println("All docs " + this.allDocs);
		System.out.println("All wronged docs " + this.invalidDocsNumber);
		System.out.println("All processed docs " + this.processedDocs);
	}

	public void printInvalidDocs() {
		System.out.println("--" + this.name + " invalid docs---");
		for (Document document : invalidDocuments) {
			document.toString();
		}
	}

	public void printAll(){
		printEmployeeReport();
		printInvalidDocs();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invalidDocsNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Employee other = (Employee) obj;
		if (invalidDocsNumber != other.invalidDocsNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public void increaseSalary() {
		this.salary = this.salary + this.salary * 0.1;
	}
}
