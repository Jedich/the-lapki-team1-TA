import Lists.LinkedList;

public class Stack<T> extends LinkedList<T> {


    public void push(T value) {
        this.addToStart(value);
    }

    public void pop() {
        if (isEmpty()) {
            this.removeLast();
        }
    }

}
