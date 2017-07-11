package homework13;

public class ComputerDemo {
	public static void main(String[] args) {
		Computer pc = new Computer();
		pc.year = 2016;
		pc.price = 1200;
		pc.isNotebook = false;
		pc.hardDiskMemory = 1153;
		pc.freeMemory = 320;
		pc.operatingSystem = "Windows 8.1";
		
		Computer lenovo = new Computer();
		lenovo.year = 2015;
		lenovo.price = 1100;
		lenovo.isNotebook = true;
		lenovo.hardDiskMemory = 983;
		lenovo.freeMemory = 720;
		lenovo.operatingSystem = "Windows 10";
		
		lenovo.useMemory(100);
		pc.changeOperationSystem("Windows 10");
		
		System.out.printf("Is the computer a laptop? %b Year: %d Price: %.2f Free memory: %d OS: %s\n", pc.isNotebook, pc.year, pc.price, pc.freeMemory, pc.operatingSystem);
		System.out.printf("Is the computer a laptop? %b Year: %d Price: %.2f Free memory: %d OS: %s\n", lenovo.isNotebook, lenovo.year, lenovo.price, lenovo.freeMemory, lenovo.operatingSystem);
	}
}
