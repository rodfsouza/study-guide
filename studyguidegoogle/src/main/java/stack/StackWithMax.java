package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackWithMax<T extends Comparable<T>> implements MyStack<T> {

    Deque<T> elements;
    Deque<MaxValueWithCount<T>> cachedMaxValueWithCount;

    int size = 0;

    public StackWithMax() {
        elements = new LinkedList<>();
        cachedMaxValueWithCount = new LinkedList<>();
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
    public void push(T o) {
        ++size;
        elements.add(o);

        if (!cachedMaxValueWithCount.isEmpty()) {
            if (o.compareTo(cachedMaxValueWithCount.peekFirst().max) == 0) {
                cachedMaxValueWithCount.peekFirst().count = cachedMaxValueWithCount.peekFirst().count + 1;
            } else if (o.compareTo(cachedMaxValueWithCount.peekFirst().max) > 0) {
                cachedMaxValueWithCount.addFirst(new MaxValueWithCount<>(o, 1));
            } else {
                cachedMaxValueWithCount.addLast(new MaxValueWithCount<>(o, 1));
            }
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T poppedElement = elements.pop();
        if (poppedElement.equals(cachedMaxValueWithCount.peekFirst().max)) {
            cachedMaxValueWithCount.peekFirst().count = cachedMaxValueWithCount.peekFirst().count - 1;

            if (cachedMaxValueWithCount.peekFirst().count == 0) {
                cachedMaxValueWithCount.removeFirst();
            }
        }

        --size;
        return poppedElement;
    }

    @Override
    public T peek() {
        return elements.peekFirst();
    }

    public T max() {
        return cachedMaxValueWithCount.peekFirst().max;
    }

    private static class MaxValueWithCount<T> {
        T max;
        int count;

        public MaxValueWithCount(T max, int count) {
            this.max = max;
            this.count = count;
        }
    }
}
