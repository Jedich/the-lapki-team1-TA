package hashtable;

import java.util.ArrayList;
import java.util.Objects;

// Class to represent entire hash table
public class HashTable<K, V> {
    // bucketArray is used to store array of chains
    private ArrayList<HashNode<K, V>> bucketArray;


    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    // Constructor (Initializes capacity, size and
    // empty chains.
    public HashTable() {

        bucketArray = new ArrayList<>();

        numBuckets = 1000;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() coule be negative.
        index = index < 0 ? index * -1 : index;
        return index;
    }



    // Returns value for a key
    public V get(Long key) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search key in chain
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        // If key not found
        return null;
    }

    private Containerable<Long, V> createBucket(){

        if (type == HashMapType.LinkedList) {
            return new LinkedListContainer<V>();
        }
        if (type == HashMapType.Tree) {
            return new TreeContainer<V>();
        }
        System.out.println("adding null");
        return null;
    }

    // Adds a key value pair to hash
    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        Containerable<Long, V> bucket = bucketArray.get(bucketIndex);

        if (bucket != null) {

            V val = bucket.get(key);
            if(val != null) {
                bucket.set(key,val);
            }else{
                size++;
                bucket.add(key, value);
            }
            return;
        }

        bucket = createBucket();
        bucketArray.add(bucketIndex, bucket);
        size++;
        bucket.add(key, value);


        // If load factor goes beyond threshold, then
        // double hash table size
//        if ((1.0 * size) / numBuckets >= 0.7) {
//            ArrayList<T> temp = bucketArray;
//            bucketArray = new ArrayList<>();
//            numBuckets = 2 * numBuckets;
//            size = 0;
//            for (int i = 0; i < numBuckets; i++)
//                bucketArray.add(null);
//
//            for(T bucket : temp) {
//
//            }
//
//            for (HashNode<Long, V> headNode : temp) {
//                while (headNode != null) {
//                    add(headNode.key, headNode.value);
//                    headNode = headNode.next;
//                }
//            }
//        }



    }

    @Override
    public String toString() {
        bucketArray.forEach(System.out::println);
        return "HashTable{" +
                "  type=" + type +
                ", numBuckets=" + numBuckets +
                ", size=" + size +
                ", sample=" + sample +
                '}';
    }

}

