package test2.employees;

import test2.documents.Document;

public class Junior extends Employee {

	public Junior(String name, double salary) {
		super(EmployeeType.JUNIOR, name, salary);
	}

	public void increaseSalary() {
		this.salary += this.salary + (0.05*this.salary);
	}

	@Override
	public void processDocument(Document d) {
		System.out.println(this.name + " is processing document " + d.getTitle());
		d.addEditor(this);
		this.setDocument(d);
		if (this.calculateError(d)) { // ako e sgreshen
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
		if (d.getComplexity() / 0.5 < 50) {
			return true;
		}
		return false;
	}
	
}
