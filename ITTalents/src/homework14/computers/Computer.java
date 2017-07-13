package homework14.computers;

public class Computer {
	private int year;
	private double price;
	private boolean isNotebook;
	private double hardDiskMemory;
	private double freeMemory;
	private String operatingSystem;
	
	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}

	public boolean isNotebook() {
		return isNotebook;
	}

	public double getHardDiskMemory() {
		return hardDiskMemory;
	}

	public double getFreeMemory() {
		return freeMemory;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setNotebook(boolean isNotebook) {
		this.isNotebook = isNotebook;
	}
	
	public void setOperatingSystem(String operatingSystem) {
		if (!operatingSystem.isEmpty() && operatingSystem != null) {
			this.operatingSystem = operatingSystem;
		} else {
			System.out.println("Invalid operating system");
		}
	}
	
	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		} else {
			System.out.println("Invalid year");
		}
	}
	
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("Invalid price");
		}
	}
	
	public void setHardDiskMemory(double hardDiskMemory) {
		if (hardDiskMemory > 0) {
			this.hardDiskMemory = hardDiskMemory;
		} else {
			System.out.println("Could not allocate desired memory");
		}
	}
	
	public void setFreeMemory(double freeMemory) {
		if (freeMemory > 0) {
			this.freeMemory = freeMemory;
		} else {
			System.out.println("Could not set desired free memory");
		}
	}
	
	public Computer() {
		this.setNotebook(false);
		this.setOperatingSystem("WinXP");
	}
	
	public Computer(int year, double price, boolean isNotebook) {
		this();
		this.setYear(year);
		this.setPrice(price);
		this.setNotebook(isNotebook);
	}
	
	public Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operatingSystem) {
		this(year, price, isNotebook);
		this.setHardDiskMemory(hardDiskMemory);
		this.setFreeMemory(freeMemory);
		this.setOperatingSystem(operatingSystem);
	}
	
	public int comparePrice(Computer c) {
		if (this.getPrice() > c.getPrice()) {
			System.out.println(this + " is more expensive than " + c);
			return -1;
		}
		if (this.getPrice() < c.getPrice()) {
			System.out.println(this + " is less expensive than " + c);
			return 1;
		}
		System.out.println("The prices are the same");
		return 0;
	}
	
	public void changeOperationSystem(String newOperationSystem) {
		this.setOperatingSystem(newOperationSystem);
	}
	
	public void useMemory(int memory) {
		if (memory >= this.getFreeMemory()) {
			System.out.println("Not enough free memory!");
		} else {
			this.freeMemory -= memory;
		}
	}
	
	@Override
	public String toString() {
		String output = "Is the computer a laptop? %b, Year: %d, Price: %.2f, HDD memory: %.2f, Free memory: %.2f, OS: %s";
		return String.format(output, isNotebook(), getYear(), getPrice(), getHardDiskMemory(), getFreeMemory(), getOperatingSystem());
	}
}
