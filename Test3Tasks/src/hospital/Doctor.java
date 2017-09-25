package hospital;

public class Doctor extends Person implements Runnable {
	private String specialization;
	private boolean isBusy = false;
	public volatile boolean dayStarted = false;
	public static Hospital h;
	
	public Doctor(String firstName, String lastName, String phone, String spec) {
		super(firstName, lastName, phone);
		this.specialization = spec;
	}

	@Override
	public void run() {
		while (true) {
			if (this.dayStarted) {
				//foreach patient from hospital get(this)
				for (Patient p : h.getDoctors().get(this)) {
					visit(p);
				}
				//daystarted = false; outside of loop
				this.dayStarted = false;
			}
		}
	}
	
	public void makePlan(Patient p) {
		Plan plan = new Plan(Hospital.getRandomDiagnose(), Plan.getRandomMed(), Plan.getRandomMed());
		p.setPlan(plan);
		p.setDoctor(this);
	}
	
	private void visit(Patient p) {
		//set busy true
		//sleep 1s
		//set busy false;
		//hospital.notifyall
		synchronized (h) {
			this.isBusy = true;
			String dep = h.getDepartment(p.getPlan().getDiagnose()).getName();
			System.out.println("Lekar " + this + " poseti " + p + " v staq " + p.getRoom().hashCode() + " ot otdelenie " + dep);
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				System.out.println("Unable to sleep Doctor");
				e.printStackTrace();
			}
			this.isBusy = false;
			h.notifyAll();	
		}
	}

	public boolean isBusy() {
		return this.isBusy;
	}
}
