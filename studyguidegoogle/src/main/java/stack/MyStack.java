package stack;

public interface MyStack<T> {

    boolean isEmpty();
    int size();
    void push(T o);
    T pop();
    T peek();
}
