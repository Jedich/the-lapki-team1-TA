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
}
