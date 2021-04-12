package data;

public class BinarySearchTree {
	public Node head;

	public BinarySearchTree() {
	}

	public void add(long value) {
		head = addRecursive(head, value);
	}

	private Node addRecursive(Node current, long value) {
		if(current == null) {
			return new Node(value);
		}
		if(value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if(value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		return current;
	}

	public boolean search(long value) {
		return containsRecursive(head, value);
	}

	private boolean containsRecursive(Node current, long value) {
		if(current == null) {
			return false;
		}
		if(value == current.value) {
			return true;
		}
		return value < current.value
				? containsRecursive(current.left, value)
				: containsRecursive(current.right, value);
	}

	public void delete(long value) {
		head = deleteRecursive(head, value);
	}

	private Node deleteRecursive(Node current, long value) {
		if(current == null) {
			return null;
		}
		if(value == current.value) {
			if(current.left == null && current.right == null) {
				return null;
			}
			if(current.right == null) {
				return current.left;
			}

			if(current.left == null) {
				return current.right;
			}
			return current;
		}
		if(value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	Node balance(Node node) {
		updateHeight(node);
		int balance = getBalance(node);
		if(balance > 1) {
			if(height(node.right.right) > height(node.right.left)) {
				node = rotateLeft(node);
			} else {
				node.right = rotateRight(node.right);
				node = rotateLeft(node);
			}
		} else if(balance < -1) {
			if(height(node.left.left) > height(node.left.right))
				node = rotateRight(node);
			else {
				node.left = rotateLeft(node.left);
				node = rotateRight(node);
			}
		}
		return node;
	}

	void updateHeight(Node n) {
		n.height = 1 + Math.max(height(n.left), height(n.right));
	}

	int height(Node n) {
		return n == null ? -1 : n.height;
	}

	int getBalance(Node n) {
		return (n == null) ? 0 : height(n.right) - height(n.left);
	}

	Node rotateRight(Node y) {
		Node x = y.left;
		Node z = x.right;
		x.right = y;
		y.left = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	Node rotateLeft(Node y) {
		Node x = y.right;
		Node z = x.left;
		x.left = y;
		y.right = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

}
