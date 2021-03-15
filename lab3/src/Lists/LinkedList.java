package Lists;

public class LinkedList<T> implements Listable<T> {
	protected Node<T> head;
	public int size;

	public LinkedList() { }

	public void add(T data) {
		if(head == null) {
			head = new Node<>(data);
		} else {
			getLast(head).next = new Node<>(data);
		}
		size++;
	}

	public void addTo(int index, T data) {
		if (index > -1) {
			Node<T> newNode = new Node<>(data);
			Node<T> temp = head;
			Node<T> current = null;
			for (int i = 0; i < index; i++) {
				current = temp;
				temp = temp.next;
			}
			current.next = newNode;
			newNode.next = temp;
			size++;
		}
	}

	public void addToStart(T value){
		++size;
		if(head == null){
			head = new Node<T>(value);
			return;
		}
		var node = new Node<T>(value);
		var tmp = head;
		head = node;
		head.next = tmp;
	}

	Node<T> getLast(Node<T> currentNode) {
		if(currentNode.next != null) {
			return getLast(currentNode.next);
		}
		return currentNode;
	}

	public T get(int index) {
		Node<T> currentNode = head;
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
			if(currentNode == null) {
				throw new IndexOutOfBoundsException();
			}
		}
		return currentNode.data;
	}

	public void removeFirst(){
		if (size == 0) return;
		else if (size == 1) {
			head = null;
			return;
		}
		head = head.next;
		--size;
	}

	public void removeFrom(int index) {
		if (index > -1) {
			Node<T> temp = head;
			Node<T> current = null;
			for (int i = 0; i < index; i++) {
				current = temp;
				temp = temp.next;
			}
			current.next = temp.next;
			size--;
		}
	}

	public void removeLast(){

		if (size == 0) return;
		else if (size == 1) {
			head = null;
			return;
		}

		var current = head;
		for (int i = 0; i < size - 2; i++) {
			current = current.next;
		}
		current.next = null;
		--size;

	}

	public long getIndexByValue(T value){
		var current = head;
		for (int i = 0; i < size - 1; i++) {
			if (current.data == value)
				return i;
			current = current.next;
		}
		return -1;
	}

	public boolean isEmpty(){
		return size == 0;
	}



}
