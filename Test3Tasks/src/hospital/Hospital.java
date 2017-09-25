package hospital;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Hospital extends Thread {
	private static final String[] DIAGNOSES = { "Grip", "Broken Heart", "Broken Skull" };
	public static String getRandomDiagnose() {
		return DIAGNOSES[new Random().nextInt(DIAGNOSES.length)];
	}
	
	private HashMap<String, Department> deps;
	private HashMap<Doctor, HashSet<Patient>> doctors;
	private HashSet<Nurse> nurses = new HashSet<>();
	
	public Department getDepartment(String diagnose) {
		if (deps.containsKey(diagnose)) {
			return deps.get(diagnose);
		}
		return null;
	}

	public Hospital() {
		this.doctors = new HashMap<Doctor, HashSet<Patient>>();
		this.deps = new HashMap<String, Department>();
		this.deps.put(DIAGNOSES[0], new Department("Virusology"));
		this.deps.put(DIAGNOSES[1], new Department("Cardiology"));
		this.deps.put(DIAGNOSES[2], new Department("Ortopedy"));
		Patient.h = this;
		Doctor.h = this;
		this.doctors.put(new Doctor("Dr", "Radeva", "897", "piene"), new HashSet<>());
		this.doctors.put(new Doctor("Dr", "Modeva", "654", "qdene"), new HashSet<>());
		this.doctors.put(new Doctor("Dr", "Dodeva", "132", "spane"), new HashSet<>());
		for (Doctor d : this.doctors.keySet()) {
			new Thread(d).start();
		}
		this.nurses.add(new Nurse("G-ca", "Georgieva", "132", 3, deps.get(DIAGNOSES[0])));
		this.nurses.add(new Nurse("G-ca", "Teodorova", "213", 4, deps.get(DIAGNOSES[1])));
		this.nurses.add(new Nurse("G-ca", "Buhleva", "634", 5, deps.get(DIAGNOSES[2])));
	}
	
	public Map<Doctor, HashSet<Patient>> getDoctors() {
		return Collections.unmodifiableMap(doctors);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.beginDay();
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				System.out.println("Unable to sleep hospital");
				e.printStackTrace();
			}
		}
	}

	private void beginDay() {
		//foreach doctor doc.daystarted = true
		for (Doctor d : this.doctors.keySet()) {
			d.dayStarted = true;
			for (Iterator<Patient> it = doctors.get(d).iterator(); it.hasNext();) {
				Patient p = it.next();
				if (p.hasToGo()) {
					it.remove();
					p.clearRoom();
					System.out.println(p + " ot pol " + p.getGender() + " s diagnoza " + p.getPlan().getDiagnose() + " beshe izpisan ");
				} else {
					p.setDaysLeft(p.getDaysLeft() - 1);
				}
			}
		}
		//nurses give meds
		for (Nurse n : nurses) {
			n.giveMeds();
		}
	}

	public synchronized void acceptPatient(Patient patient) {
		Doctor doc = null;
		while ((doc = getFreeDoctor()) == null) {
			try {
				wait();
				//on notify this thread starts from here
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		doc.makePlan(patient);
		String diagnose = patient.getPlan().getDiagnose();
		String gender = patient.getGender();
		Room room = getRoom(diagnose, gender);
		if (room != null) {
			System.out.println(patient + " ot pol " + patient.getGender() + " e priet s diagnoza " + diagnose + " lekar " + patient.getDoctor());
			room.addPatient(patient);
			this.doctors.get(doc).add(patient);
		}
	}

	private Room getRoom(String diagnose, String gender) {
		for (Room r : deps.get(diagnose).getRooms()) {
			if (r.isEmpty() || (!r.isEmpty() && r.getGender().equals(gender))) {
				return r;
			}
		}
		return null;
	}

	private Doctor getFreeDoctor() {
		Doctor free = null; 
		for (Doctor d : doctors.keySet()) {
			if (!d.isBusy()) {
				free = d;
				break;
			}
		}
		return free;
	}
}
