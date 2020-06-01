package linkedlist;

public class DoubleNode<T> {

    public T data;
    public DoubleNode<T> previous;
    public DoubleNode<T> next;

    public DoubleNode(T data) {
        this.data = data;
        previous = null;
        next = null;
    }

    public DoubleNode() {
        previous = null;
        next = null;
    }
}
