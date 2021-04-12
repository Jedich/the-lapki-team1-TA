package data;

public class AVLTree extends BinarySearchTree {
	@Override
	public void add(long value) {
		super.add(value);
		balancing();
	}

	@Override
	public void delete(long value) {
		super.delete(value);
		balancing();
	}

	@Override
	public boolean search(long value){
		return super.search(value);
	}
}
