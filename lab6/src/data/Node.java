package data;

public class Node {
	long value;
	int height;
	Node left, right;

	public Node(long value) {
		this.value = value;
		right = null;
		left = null;
	}
}
