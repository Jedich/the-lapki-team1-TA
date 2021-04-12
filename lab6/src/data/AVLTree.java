package data;

public class AVLTree extends BinarySearchTree {
	@Override
	public void add(long value) {
		super.add(value);
		balance(head);
	}

	@Override
	public void delete(long value) {
		super.delete(value);
		balance(head);
	}
}
