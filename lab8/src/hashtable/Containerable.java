package hashtable;

public interface Containerable<Long, V> {

    abstract void add(Long k, V v);
    abstract void remove(Long k);
    abstract V get(Long key);
    abstract void set(Long k, V v);
}
