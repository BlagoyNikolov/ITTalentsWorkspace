package homework13;

public class Computer {
	int year;
	double price;
	boolean isNotebook;
	int hardDiskMemory;
	int freeMemory;
	String operatingSystem;
	
	public void changeOperationSystem(String newOperationSystem) {
		operatingSystem = newOperationSystem;
	}
	
	public void useMemory(int memory) {
		if (memory >= freeMemory) {
			System.out.println("Not enough free memory!");
		} else {
			freeMemory -= memory;
		}
	}
}
