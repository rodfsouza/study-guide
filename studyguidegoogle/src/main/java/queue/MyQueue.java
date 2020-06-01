package queue;

public interface MyQueue<T> {

    boolean isEmpty();
    int size();
    void enqueue(T o);
    T dequeue();
    T peek();
}
