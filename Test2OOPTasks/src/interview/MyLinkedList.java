package interview;

public class MyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	class Node<T> {
		private Node<T> prev;
		private Node<T> next;
		private T value;
		
		public Node(T value) {
			this.prev = null;
			this.next = null;
			this.value = value;
		}
	}
	
	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		this.size++;
	}
	
	public T get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.value;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
}
