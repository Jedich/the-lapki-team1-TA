package tree;

public class Node<V> {
	public long key;
	public V value;
	int height;
	public Node left, right;

	public Node(long key, V value) {
		this.key = key;
		right = null;
		left = null;
		this.value = value;
	}



}


