package homework17;

public class AllWork {
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;

	public Task[] getTasks() {
		return tasks;
	}

	public void setTasks(Task[] tasks) {
		this.tasks = tasks;
	}

	public int getFreePlacesForTasks() {
		return freePlacesForTasks;
	}

	public void setFreePlacesForTasks(int freePlacesForTasks) {
		this.freePlacesForTasks = freePlacesForTasks;
	}

	public void setCurrentUnassignedTask(int currentUnassignedTask) {
		this.currentUnassignedTask = currentUnassignedTask;
	}

	public AllWork() {
		this.setTasks(new Task[10]);
		this.setFreePlacesForTasks(10);
		this.setCurrentUnassignedTask(0);
	}

	public void addTask(Task task) {
		if (task != null) {
			this.getTasks()[this.getTasks().length - freePlacesForTasks--] = task;
		} else {
			System.out.println("Invalid task");
		}
	}

	public Task getNextTask() {
		if (currentUnassignedTask == -1) {
			return null;
		}
		for (int i = currentUnassignedTask; i < tasks.length - 1; i++) {
			if (tasks[i] != null) {
				Task task = tasks[i];
				// tasks[i]= null;
				currentUnassignedTask++;
				return task;
			}
		}
		if (tasks[tasks.length - 1] != null) {
			Task task = tasks[tasks.length - 1];
			tasks[tasks.length - 1] = null;
			currentUnassignedTask = -1;
			return task;
		}
		return null;
	}

	public boolean isAllWorkDone() {
		boolean flag = false;
		for (int i = 0; i < this.getTasks().length; i++) {
			if (this.getTasks()[i] == null && this.getTasks()[i].getWorkingHours() == 0) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
