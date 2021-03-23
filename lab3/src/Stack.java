import Lists.LinkedList;

public class Stack<T> extends LinkedList<T> {


    public void push(T value) {
        this.add(value);
    }

    public void pop() {
        if (!isEmpty()) {
            this.removeLast();
        }
    }

}
