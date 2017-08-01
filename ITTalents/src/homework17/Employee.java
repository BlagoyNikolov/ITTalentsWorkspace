package homework17;

public class Employee {
	private String name;
	private Task currentTask;
	private double hoursLeft;
	private static AllWork allWork;

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

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task task) {
		if (task != null) {
			this.currentTask = task;
		} else {
			System.out.println("Invalid task");
		}
	}

	public double getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(double hoursLeft) {
		if (hoursLeft >= 0) {
			this.hoursLeft = hoursLeft;
		} else {
			System.out.println("Invalid hours left");
		}
	}
	
	public AllWork getAllWork() {
		return allWork;
	}

	public void setAllWork(AllWork allWork) {
		if (allWork != null) {
			Employee.allWork = allWork;
		} else {
			System.out.println("Invalid allwork");
		}
	}

	public Employee(String name) {
		this.setName(name);
	}
	
	public void startWorkingDay() {
		this.setHoursLeft(8);
//		this.setCurrentTask(this.getAllWork().getNextTask());
//		work();
//		if (this.getCurrentTask().getWorkingHours() == 0) {
//			this.setCurrentTask(this.getAllWork().getNextTask());
//			work();
//		}
	}

	public void work() {
		if (this.getCurrentTask() == null || this.getCurrentTask().getWorkingHours() <= 0) {
			Task t = Employee.allWork.getNextTask();
			if (t != null) {
				this.setCurrentTask(t);
			} else {
				System.out.println("No free task");
			}
		}
		if (this.getHoursLeft() > this.getCurrentTask().getWorkingHours()) {
			this.setHoursLeft(this.getHoursLeft() - this.getCurrentTask().getWorkingHours());
			this.getCurrentTask().setWorkingHours(0);
			showReport();
		} else if (this.getHoursLeft() < this.getCurrentTask().getWorkingHours()) {
			this.getCurrentTask().setWorkingHours(this.getCurrentTask().getWorkingHours() - this.getHoursLeft());
			this.setHoursLeft(0);
			showReport();
		} else if (this.getHoursLeft() == this.getCurrentTask().getWorkingHours()) {
			this.setHoursLeft(0);
			this.getCurrentTask().setWorkingHours(0);
			showReport();
		}
	}

	public void showReport() {
		System.out.println("Worker name: " + this.getName() + " Task name: " + this.getCurrentTask().getName());
		System.out.println("Worker hours left: " + this.getHoursLeft() + " Task hours left: " + this.getCurrentTask().getWorkingHours());
	}
}
