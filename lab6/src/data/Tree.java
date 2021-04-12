package data;

public interface Tree {
    void add(long value);

    void delete(long value);

    boolean search(long value);

    void balancing();

    void clear();

}
