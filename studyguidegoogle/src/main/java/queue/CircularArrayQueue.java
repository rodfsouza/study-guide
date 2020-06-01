package queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue<Object> {

    private static final int DEFAULT_SIZE = 16;
    private static final int RESIZE_FACTOR = 2;

    private int size = 0;
    private Object[] array;

    private int head;
    private int tail;

    public CircularArrayQueue() {
        array = new Object[DEFAULT_SIZE];
        this.head = 0;
        this.tail = 0;
    }

    public CircularArrayQueue(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException();
        }

        array = new Object[initialSize];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isFull() {
        return tail == array.length - 1;
    }

    @Override
    public void enqueue(Object o) {
        if (isFull()) {
            //Makes the queue elements appear consecutively
            Collections.rotate(Arrays.asList(array), -head);

            head = 0;
            tail = size;

            array = Arrays.copyOf(array, size * RESIZE_FACTOR);
        }

        array[tail] = o;
        tail = (tail + 1) % array.length;
        ++size;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        --size;
        Object result = array[head];
        head = (head + 1) % array.length;

        return result;
    }

    @Override
    public Object peek() {
        return array[head];
    }
}
