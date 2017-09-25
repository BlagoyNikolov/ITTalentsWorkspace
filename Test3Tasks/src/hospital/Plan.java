package hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Plan {
	private static final String[] MEDS = { "Aspirin", "Analgin", "Paracetamol", "VItamin C" };
	public static String getRandomMed() {
		return MEDS[new Random().nextInt(MEDS.length)];
	}
	
	private String diagnose;
	private ArrayList<String> medsList;
	
	public Plan(String diagnose, String... meds) {
		this.diagnose = diagnose;
		this.medsList = new ArrayList<>();
		for (String string : meds) {
			medsList.add(string);
		}
	}
	
	public String getDiagnose() {
		return diagnose;
	}
	
	public List<String> getMedsList() {
		return Collections.unmodifiableList(medsList);
	}
}
