package test2.documents;

import java.util.Random;
import test2.employees.Employee;

public abstract class Document implements Comparable<Document> {
	protected String title;
	protected int complexity;
	protected Employee editor;
	protected String status;
	
	public Document(String title) {
		this.title = title;
		this.complexity = new Random().nextInt(20) + 1;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getComplexity() {
		return complexity;
	}
	
	public abstract void addEditor(Employee e);
	public abstract String toString();
}
