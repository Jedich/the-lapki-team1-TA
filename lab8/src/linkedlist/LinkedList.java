package linkedlist;

public class LinkedList<T> {
	protected Node<T> head;
	public int size;

	public LinkedList() { }

	public void add(Long key, T data) {
		if(head == null) {
			head = new Node<>(key, data);
		} else {
			getLast(head).next = new Node<>(key, data);
		}
		size++;
	}

	public void addTo(long index, T data) {
		if (index > -1) {
			Node<T> newNode = new Node<>(index, data);
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

	Node<T> getLast(Node<T> currentNode) {
		if(currentNode.next != null) {
			return getLast(currentNode.next);
		}
		return currentNode;
	}

	public T get(long key) {
		if (head == null)
			return null;
		Node<T> currentNode = head;
		if(key < 0) {
			throw new IndexOutOfBoundsException();
		}
		while(key != currentNode.key) {
			currentNode = currentNode.next;
			if (currentNode == null)
				return null;
		}
		return currentNode.data;
	}

	public Node<T> getNode(long key) {
		Node<T> currentNode = head;
		if(key < 0) {
			throw new IndexOutOfBoundsException();
		}
		while(key != currentNode.key) {
			currentNode = currentNode.next;
		}
		return currentNode;
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

	public void removeFrom(long key) {
		Node<T> prev = head;
		Node<T> current = head;
		while(key != current.key) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;

		size--;
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
