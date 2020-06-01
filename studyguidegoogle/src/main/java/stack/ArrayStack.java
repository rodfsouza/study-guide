package stack;

public class ArrayStack implements MyStack<Object> {

    private static final int DEFAULT_SIZE = 16;
    private int size;
    private Object[] array;

    int head = 0;

    public ArrayStack(int initialSize) {
        if (initialSize <= 0) {
            throw new IllegalArgumentException();
        }
        array = new Object[initialSize];
    }

    public ArrayStack() {
        array = new Object[DEFAULT_SIZE];
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
    public void push(Object data) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        array[head++] = data;
        size++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        size--;
        return array[--head];
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return array[head];
    }


    public void clear() {
        head = 0;
        size = 0;
    }
}
