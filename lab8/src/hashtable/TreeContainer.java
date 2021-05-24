package hashtable;

import hashtable.Containerable;
import tree.BinarySearchTree;
import tree.Node;


public class TreeContainer<V> implements Containerable<Long, V> {

    BinarySearchTree<V> tree = new BinarySearchTree<>();

    @Override
    public void add(Long key, V o2) {
        tree.add(key, o2);
    }

    @Override
    public void remove(Long key) {
        tree.delete(key);
    }

    public V get(Long key) {
        return tree.get(key);
    }

    @Override
    public void set(Long key, V v) {
        Node<V> node = tree.getNode(key);
        node.value = v;
    }
    @Override
    public String toString() {
        System.out.print("size :" + tree.size);
        return "";
    }
}
