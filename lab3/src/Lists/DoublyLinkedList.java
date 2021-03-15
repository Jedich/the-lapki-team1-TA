package Lists;

public class DoublyLinkedList<T> extends LinkedList<T> implements Listable<T> {
	protected Node<T> tail;

	@Override
	public void add(T data) {
		if(head == null) {
			head = new Node<>(data);
			tail = head;
		} else {
			var newNode = new Node<>(data);
			var oldLast = getLast(head);
			oldLast.next = newNode;
			newNode.prev = oldLast;
			tail = newNode;
		}
		size++;
	}

	@Override
	public T get(int index) {
		if(index < size/2) {
			return super.get(index);
		}
		else {
			Node<T> currentNode = tail;
			if (index < 0) {
				throw new IndexOutOfBoundsException();
			}
			for (int i = size-1; i > index; i--) {
				currentNode = currentNode.prev;
				if (currentNode == null) {
					throw new IndexOutOfBoundsException();
				}
			}
			return currentNode.data;
		}
	}
}
