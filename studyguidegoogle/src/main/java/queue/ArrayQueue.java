package queue;

public class ArrayQueue implements MyQueue<Object> {

    private static final int DEFAULT_SIZE = 16;
    private int size = 0;
    private Object[] array;

    private int head;
    private int tail;

    public ArrayQueue(int initialSize) {
        if (initialSize <= 0) {
            throw new IllegalArgumentException();
        }
        array = new Object[initialSize];
        head = 0;
        tail = 0;
    }

    public ArrayQueue() {
        array = new Object[DEFAULT_SIZE];
        head = 0;
        tail = 0;
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
        return size == array.length - 1;
    }

    @Override
    public void enqueue(Object data) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        if (isEmpty()) {
            array[head] = data;
            tail++;
        } else {
            array[tail++] = data;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            Object oldHead = array[head++];
            size--;
            return oldHead;
        }
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            return array[head];
        }
    }
}
