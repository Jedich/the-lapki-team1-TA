package linkedlist;

public class Node<T> {
	public long key;
	public T data;
	public Node<T> next;
	public Node<T> prev;

	public Node(Long key, T data) {
		this.key = key;
		this.data = data;
	}


}
