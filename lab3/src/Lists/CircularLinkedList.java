package Lists;

public class CircularLinkedList<T> extends LinkedList<T> implements Listable<T> {
	@Override
	public void add(T data) {
		if(head == null) {
			head = new Node<>(data);
			head.next = head;
		} else {
			var temp = getLast(head);
			temp.next = new Node<>(data);
			temp.next.next = head;
		}
		size++;
	}

	@Override
	Node<T> getLast(Node<T> currentNode) {
		if(currentNode.next != head) {
			return this.getLast(currentNode.next);
		}
		return currentNode;
	}

	@Override
	public void addToStart(T value) {
		if(head == null){
			head = new Node<T>(value);
			head.next = head;
			return;
		}
		var node = new Node<T>(value);
		var tmp = head;
		var last = getLast(head);
		head = node;
		head.next = tmp;
		last.next = head;
		++size;
	}

	@Override
	public void removeFirst() {
		if (size == 0) return;
		else if (size == 1) {
			size = 0;
			head.next = null;
			head = null;
			return;
		}
		var last = getLast(head);
		head = head.next;
		last.next = head;
		--size;
	}

	@Override
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
		current.next = head;
		--size;

	}
}
