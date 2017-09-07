package interview;

public class MyHashSet<T> {
	private MyLinkedList<T>[] cells;
	private double loadFactor;
	private int size = 0;
	
	public MyHashSet() {
		this.cells = new MyLinkedList[16];
		this.loadFactor = 0.75f;
		this.fillCells();
	}
	
	public MyHashSet(int size) {
		this.cells = new MyLinkedList[size];
		this.loadFactor = 0.75f;
		this.fillCells();
	}
	
	public MyHashSet(int size, double loadFactor) {
		this.cells = new MyLinkedList[size];
		this.loadFactor = loadFactor;
		this.fillCells();
	}
	
	private void fillCells() {
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new MyLinkedList<>();
		}
	}
	
	public boolean add(T item) {
		int index = item.hashCode() % cells.length;
		MyLinkedList<T> list = cells[index];
		if (list.isEmpty()) {
			list.add(item);
			this.size++;
			return true;
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(item)) {
					return false;
				}
			}
			list.add(item);
			this.size++;
			return true;
		}
	}
	
	public int size() {
		return this.size;
	}
}
