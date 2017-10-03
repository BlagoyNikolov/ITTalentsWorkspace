package test2.employees;

import test2.documents.Document;

public class Regular extends Employee implements INotJunior {

	public Regular(String name, double salary) {
		super(EmployeeType.REGULAR, name, salary);
	}
	
	public void increaseSalary() {
		this.salary += this.salary + (0.05*this.salary);
	}

	@Override
	public void transferToOther() {
		Junior j = this.department.getRandomJunior();
		System.out.println(this.name + " transfered " + this.document + " to " + j.name);
		j.setDocument(this.document);
		this.document = null;
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
		if (d.getComplexity() / 0.4 < 50) {
			return true;
		}
		return false;
	}
}
