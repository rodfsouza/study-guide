package queue;

import java.util.Stack;

public class StackQueue<T> implements MyQueue<T> {

    Stack<T> enqueue;
    Stack<T> dequeue;

    int size = 0;

    public StackQueue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T o) {
        ++size;
        enqueue.push(o);
    }

    @Override
    public T dequeue() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }

        --size;
        return dequeue.pop();
    }

    @Override
    public T peek() {
        return dequeue.peek();
    }
}
