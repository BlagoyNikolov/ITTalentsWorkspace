package test2.documents;
import test2.employees.Employee;

public class OrdinaryDocument extends Document {

	public OrdinaryDocument(String title) {
		super(title);
	}

	@Override
	public void addEditor(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "OrdinaryDocument [title=" + title + ", complexity=" + complexity + ", editor=" + editor + ", status="
				+ status + "]";
	}

	@Override
	public int compareTo(Document o) {
		// TODO Auto-generated method stub
		return this.title.compareTo(o.title);
	}

}
