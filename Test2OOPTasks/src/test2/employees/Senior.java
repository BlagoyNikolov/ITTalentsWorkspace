package test2.employees;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import test2.documents.Document;

public class Senior extends Employee implements ISenior, INotJunior  {

	public Senior(String name, double salary) {
		super(EmployeeType.SENIOR, name, salary);
	}
	
	@Override
	public void transferToOther() {
		if (new Random().nextBoolean()) {
			Regular r = this.department.getRandomRegular();
			System.out.println(this.name + " transfered " + this.document + " to " + r.name);
			r.setDocument(this.document);
			this.document = null;
		} else {
			Junior j = this.department.getRandomJunior();
			System.out.println(this.name + " transfered " + this.document + " to " + j.name);
			j.setDocument(this.document);
			this.document = null;
		}
	}

	public void fireSmotan() {
		int max = 0;
		int current = 0;
		Employee notlucky = null;
		TreeSet<Employee> set = this.department.getEmployees();
		for (Employee employee : set) {
			current = employee.getInvalidDocsNumber();
			if (current > max) {
				max = current;
				notlucky = employee;
			}
		}
		this.department.fireEmployee(notlucky);
	}

	@Override
	public void processDocument(Document d) {
		System.out.println(this.name + " is processing document " + d.getTitle());
		d.addEditor(this);
		this.setDocument(d);
		if (this.calculateError(d)) {// ako e sgreshen
			this.addInvalid();
			this.addToAllDocs();
			this.addInvalid();
			this.addToInvalid(d);
			System.out.println("Doc sgreshen maybe pls");
		} else {
			this.addProcessed();
			this.addToAllDocs();
			System.out.println("Doc processed succesfully maybe pls");
		}
	}

	@Override
	public boolean calculateError(Document d) {
		if (((d.getComplexity() / 0.3) + new Random().nextInt(20)+1 ) < 50) {
			return true;
		}
		return false;
	}

	
}
