package hashtable;

class HashNode<Long, V> {
    Long key;
    V value;
    final int hashCode;

    // Reference to next node
    HashNode<Long, V> next;

    // Constructor
    public HashNode(Long key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
