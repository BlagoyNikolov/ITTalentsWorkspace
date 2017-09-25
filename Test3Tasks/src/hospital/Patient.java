package hospital;

import java.util.ArrayList;
import java.util.Random;

public class Patient extends Person implements Runnable {
	public static final ArrayList<String> GENDERS;
	public static Hospital h;
	static {
		GENDERS = new ArrayList<>();
		GENDERS.add("Male");
		GENDERS.add("Female");
	}
	
	private int age;
	private Plan plan;
	private int daysLeft;
	private String gender;
	private Room r;
	private Doctor d;
	
	public Patient(String firstName, String lastName, String phone, int age, String gender) {
		super(firstName, lastName, phone);
		this.age = age;
		if (GENDERS.contains(gender)) {
			this.gender = gender;
		}
	}
	
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
		this.daysLeft = new Random().nextInt(3) + 3; 
	}
	
	public Doctor getDoctor() {
		return d;
	}
	
	public void setDoctor(Doctor d) {
		this.d = d;
	}
	
	public int getDaysLeft() {
		return daysLeft;
	}
	
	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
	
	public String getGender() {
		return gender;
	}
	
	public Room getRoom() {
		return r;
	}
	
	public void setRoom(Room r) {
		this.r = r;
	}
	
	public boolean hasToGo() {
		return this.daysLeft == 0;
	}

	@Override
	public void run() {
		h.acceptPatient(this);
	}

	public void clearRoom() {
		this.r.removePatient(this);
		this.r = null;
	}

	public void receiveMeds(Nurse n) {
		for (String med : this.getPlan().getMedsList()) {
			System.out.println("Sestra " + n.getFirstName() + " dade na pacient " + this + " v staq " + r.hashCode() + " ot otdelenie " + n.getDept().getName() + " lekarstvo " + med);
		}
	}
}
