
package tree;


public class BinarySearchTree<V> {
	public Node<V> head;
	public int size = 0;


	public void add(long key, V val) {
		head = addRecursive(head, key, val);
		//balancingRecursive(head);
		size++;
	}

	private Node addRecursive(Node current, long key, V val) {
		if(current == null) {
			return new Node<V>(key, val);
		}
		if(key < current.key) {
			current.left = addRecursive(current.left, key, val);
		} else if(key > current.key) {
			current.right = addRecursive(current.right, key, val);
		} else {
			return current;
		}
		return current;
	}


	public V get(long key) {
		var tmp = searchRecursive(head, key);
		if (tmp == null)
			return null;
		return tmp.value;
	}

	protected Node<V> searchRecursive(Node<V> root, long key) {
		if (root == null || root.key == key)
			return root;
		if (root.key > key)
			return searchRecursive(root.left, key);
		return searchRecursive(root.right, key);
	}

	public Node<V> getNode(long key) {
		head = searchRecursive(head, key);
		return head;
	}


	public void delete(long key ) {
		head = deleteRecursive(head, key);
		size--;
	}

	private Node deleteRecursive(Node current, long key) {
		if(current == null) {
			return null;
		}
		if(key == current.key) {
			if(current.left == null && current.right == null) {
				return null;
			} else if(current.right == null) {
				return current.left;
			} else if(current.left == null) {
				return current.right;
			} else {
				long smallestValue = findSmallestValue(current.right);
				current.value = smallestValue;
				current.right = deleteRecursive(current.right, smallestValue);
				return current;
			}
		}
		if(key < current.key) {
			current.left = deleteRecursive(current.left, key);
			return current;
		}
		current.right = deleteRecursive(current.right, key);
		return current;
	}

	private long findSmallestValue(Node<V> root) {
		return root.left == null ? root.key : findSmallestValue(root.left);
	}

	private Node<V> balanceNode(Node<V> node) {
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

	void updateHeight(Node<V> n) {
		n.height = 1 + Math.max(height(n.left), height(n.right));
	}

	int height(Node<V> n) {
		return n == null ? -1 : n.height;
	}

	int getBalance(Node<V> n) {
		return (n == null) ? 0 : height(n.right) - height(n.left);
	}

	Node<V> rotateRight(Node<V> y) {
		Node<V> x = y.left;
		Node<V> z = x.right;
		x.right = y;
		y.left = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	Node<V> rotateLeft(Node<V> y) {
		Node<V> x = y.right;
		Node<V> z = x.left;
		x.left = y;
		y.right = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}
	

	public void balancing() {
		balancingRecursive(head);
	}

	void balancingRecursive(Node<V> root) {
		if (root != null) {
			balancingRecursive(balanceNode(root.left));
			balancingRecursive(balanceNode(root.right));
		}
	}

	public void clear() {
		this.head = null;
	}
}
