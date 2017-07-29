package homework17;

public class Task {
	private String name;
	private double workingHours;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}
	}
	
	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		if (workingHours >= 0) {
			this.workingHours = workingHours;
		} else {
			System.out.println("Invalid working hours");
		}
	}
	
	public Task(String name, double workingHours) {
		this.setName(name);
		this.setWorkingHours(workingHours);
	}
}
