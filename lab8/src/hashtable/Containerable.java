package hashtable;

public interface Containerable<K,V> {
    void add(K k, V v);
    void remove(K k);
    void set(K k, V v);
}
