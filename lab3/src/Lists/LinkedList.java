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
}
