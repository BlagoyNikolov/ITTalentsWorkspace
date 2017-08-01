package homework17;

public class Demo {
	public static void main(String[] args) {
		Employee pesho = new Employee("Pesho");
		Employee blago = new Employee("Blago");
		Task task1 = new Task("coding", 7);
		Task task2 = new Task("driving", 10);
		Task task3 = new Task("gaming" , 4);
		Task task4 = new Task("eating", 2);
		Task task5 = new Task("code review", 9);
		Task task6 = new Task("testing" , 3);
		Task task7 = new Task("meeting", 1);
		Task task8 = new Task("scrum", 2);
		Task task9 = new Task("releasing" , 12);
		Task task10 = new Task("debugging", 10);
		AllWork allWork = new AllWork();
		allWork.addTask(task1);
		allWork.addTask(task2);
		allWork.addTask(task3);
		allWork.addTask(task4);
		allWork.addTask(task5);
		allWork.addTask(task6);
		allWork.addTask(task7);
		allWork.addTask(task8);
		allWork.addTask(task9);
		allWork.addTask(task10);
		pesho.setAllWork(allWork);
		blago.setAllWork(allWork);
		
		int i = 1;
		while (true) {
			System.out.println("------ Day " + i + " -----");
			pesho.startWorkingDay();
			pesho.work();
			System.out.println("-------");
			blago.startWorkingDay();
			blago.work();
			i++;
			if (allWork.isAllWorkDone()) {
				break;
			}
		}
		
//		Employee ivan = new Employee("Ivan");
//		Task task1 = new Task("coding", 7);
//		ivan.setHoursLeft(4);
//		ivan.setCurrentTask(task1);
//		ivan.work();
//		ivan.showReport();
//		
//		Employee blago = new Employee("Blago");
//		Task task2 = new Task("driving", 10);
//		blago.setHoursLeft(8);
//		blago.setCurrentTask(task2);
//		blago.work();
//		blago.showReport();
//		
//		Employee pesho = new Employee("Pesho");
//		Task task3 = new Task("gaming" , 4);
//		pesho.setHoursLeft(4);
//		pesho.setCurrentTask(task3);
//		pesho.work();
//		pesho.showReport();
	}
}
