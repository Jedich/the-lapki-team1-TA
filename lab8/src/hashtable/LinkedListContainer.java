package hashtable;

import linkedlist.LinkedList;

public class LinkedListContainer<V> implements Containerable<Long, V> {

    LinkedList<V> list = new LinkedList<>();

    @Override
    public void add(Long key, V value) {
        list.add(key, value);
    }

    @Override
    public void remove(Long key) {
        list.removeFrom(key);
    }

    @Override
    public V get(Long key) {
        return list.get(key);
    }

    @Override
    public void set(Long key, V v) {
        var n = list.getNode(key);
        n.data = v;
    }


    @Override
    public String toString() {
        System.out.print("size :" + list.size);
        return "";
    }
}
