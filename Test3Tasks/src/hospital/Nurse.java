package hospital;

public class Nurse extends Person {
	private int exp;
	private Department dept;

	public Nurse(String firstName, String lastName, String phone, int exp, Department dept) {
		super(firstName, lastName, phone);
		this.exp = exp;
		this.dept = dept;
	}
	
	public Department getDept() {
		return dept;
	}
	
	public void giveMeds() {
		for (Room r : dept.getRooms()) {
			for (Patient p : r.getPatients()) {
				p.receiveMeds(this);
			}
		}
	}
}
