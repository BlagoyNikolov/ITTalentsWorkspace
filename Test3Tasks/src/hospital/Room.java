package hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
	private String gender;
	private static final int MAX_PLACES = 3;
	private ArrayList<Patient> patients = new ArrayList<>();
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isEmpty() {
		return patients.size() == 0;
	}
	
	public void addPatient(Patient p) {
		if (this.patients.size() < MAX_PLACES) {
			if (isEmpty()) {
				setGender(p.getGender());
			}
			if (this.gender.equals(p.getGender())) {
				this.patients.add(p);
				p.setRoom(this);
			}
		}
	}
	
	public void removePatient(Patient p) {
		this.patients.remove(p);
		if (isEmpty()) {
			this.setGender(null);
		}
	}
	
	public List<Patient> getPatients() {
		return Collections.unmodifiableList(patients);
	}
}
