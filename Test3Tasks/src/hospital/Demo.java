package hospital;

import java.util.Random;

public class Demo {
	public static void main(String[] args) {
		Hospital h = new Hospital();
		h.start();
		for (int i = 0; i < 5; i++) {
			Patient p = new Patient("Patient", "number" + i, "91284", 21, Patient.GENDERS.get(new Random().nextInt(Patient.GENDERS.size())));
			new Thread(p).start();
		}
	}
}
