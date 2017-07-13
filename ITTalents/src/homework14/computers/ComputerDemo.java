package homework14.computers;

public class ComputerDemo {
	public static void main(String[] args) {
		Computer laptop = new Computer();
		System.out.println(laptop.toString());
		
		Computer mac = new Computer(2015, 3000, true);
		mac.changeOperationSystem("macOS Sierra");
		System.out.println(mac.toString());
		
		Computer pc = new Computer(2016, 1200, false, 980, 260, "Windows 10");
		System.out.println(pc.toString());
		
		pc.comparePrice(mac);
		mac.comparePrice(pc);
		
		pc.useMemory(150);
		System.out.println(pc.toString());
	}
}
