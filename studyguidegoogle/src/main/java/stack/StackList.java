package stack;

import linkedlist.DoubleNode;
import linkedlist.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackList<T extends Comparable<T>> implements Iterable<T>, MyStack<T> {

    DoubleNode<T> head;
    LinkedList<T> stackMax;
    int size = 0;

    public StackList(T data) {
        addFirstNode(data);
    }

    public StackList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T data) {
        if (isEmpty()) {
            addFirstNode(data);
        } else {
            DoubleNode<T> newHead = new DoubleNode<>(data);
            newHead.next = head;
            head.previous = newHead;
            head = newHead;
            size++;

            addMaxItem(data);
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            DoubleNode<T> oldHead = head;
            head = head.next;

            if (head != null) {
                head.previous = null;
            }

            size--;
            removeMaxItem(oldHead.data);
            return oldHead.data;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            return head.data;
        }
    }

    public T max() {
        return stackMax.peekFirst();
    }

    @Override
    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    private void addFirstNode(T data) {
        head = new DoubleNode<>(data);
        stackMax = new LinkedList<>(data);
        size++;
    }

    private void addMaxItem(T data) {
        if (stackMax.isEmpty()) {
            stackMax.addFront(data);
        } else if (data.compareTo(stackMax.peekFirst()) > 0) {
            stackMax.addFront(data);
        }
    }

    private void removeMaxItem(T data) {
        if (stackMax.isEmpty()) {
            return;
        } else if (data.compareTo(stackMax.peekFirst()) == 0) {
            stackMax.removeFirst();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackListIterator<>();
    }

    class StackListIterator<T> implements Iterator<T> {

        DoubleNode<T> current = (DoubleNode<T>) StackList.this.head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T oldHead = (T) current.data;
            current = current.next;
            return oldHead;
        }
    }
}
