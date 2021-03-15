import Lists.LinkedList;


public class Queue<T> extends LinkedList<T> {

    @Override
    public void add(T value) {
        super.add(value);
    }

    public void remove() {
        this.removeFirst();
    }




}
