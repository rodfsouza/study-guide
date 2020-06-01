package queue;

import linkedlist.DoubleNode;

public class QueueList<T extends Comparable> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    int size = 0;

    public QueueList(T data) {
        addFirstNode(data);
    }

    public QueueList() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T data) {
        if (isEmpty()) {
            addFirstNode(data);
        } else {
            DoubleNode<T> newTail = new DoubleNode<>(data);
            tail.next = newTail;
            newTail.previous = tail;
            tail = newTail;
            size++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            DoubleNode<T> oldHead = head;
            head = head.next;
            head.previous = null;
            size--;
            return oldHead.data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            return head.data;
        }
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            return tail.data;
        }
    }

    private void addFirstNode(T data) {
        head = new DoubleNode<>(data);
        tail = head;
        size++;
    }
}
