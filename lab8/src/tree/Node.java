package tree;

public class Node<V> {
	public long key;
	public V value;
	int height;
	public Node left, right;

	public Node(long value) {
		this.value = value;
		right = null;
		left = null;
	}



}


