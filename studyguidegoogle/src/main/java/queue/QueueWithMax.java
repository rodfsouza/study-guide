package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueWithMax<T extends Comparable> implements MyQueue<T> {

    Deque<T> maxItems;
    Queue<T> items;

    int size = 0;

    public QueueWithMax() {
        maxItems = new LinkedList<>();
        items = new LinkedList<>();
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
        items.add(o);
        insertToMax(o);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }


        if (items.peek().compareTo(maxItems.peek()) == 0) {
            maxItems.removeFirst();
        }

        --size;
        return items.poll();
    }

    @Override
    public T peek() {
        return items.peek();
    }

    public T max() {
        return maxItems.pollFirst();
    }

    private void insertToMax(T o) {
        while (!maxItems.isEmpty()) {
            if (maxItems.getLast().compareTo(o) >= 0) {
                break;
            }
            maxItems.removeLast();
        }
        maxItems.addLast(o);
    }
}
