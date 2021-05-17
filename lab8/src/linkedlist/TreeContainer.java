package linkedlist;

import hashtable.Containerable;
import tree.BinarySearchTree;
import tree.Tree;

public class TreeContainer<V> implements Containerable<Long, V> {

    Tree tree = new BinarySearchTree();

    @Override
    public void add(Long key, V o2) {
        tree.add();
    }

    @Override
    public void remove(Long o) {

    }

    @Override
    public void set(Long key, V v) {

    }
}
