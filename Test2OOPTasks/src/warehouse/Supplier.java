package warehouse;

public class Supplier {
	private String name;
	private Warehouse warehouse;
	
	public String getName() {
		return name;
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	public Supplier(String name, Warehouse warehouse) {
		this.name = name;
		this.warehouse = warehouse;
	}
	
	public void fillWarehouse() {
		this.getWarehouse().fillWarehouse();
	}
}
