package caches;

import java.util.Objects;

public class LRUCache {

    Node[] nodes;
    Node head;
    Node tail;

    int capacity;
    int size;


    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        nodes = new Node[capacity];
    }

    public int get(int key) {
        int hashedKey = hash(key);
        Node n = fetchNode(hashedKey);
        if (n == null) {
            return -1;
        }

        n.hit++;
        //write(hashedKey, n);
        insertFront(n);
        removeFromEnd();
        return n.value;
    }

    public void put(int key, int value) {
        if (size >= capacity) {
            int hashedTail = hash(tail.key);
            write(hashedTail, null);
            removeFromEnd();
            --size;
        }

        Node node = new Node(key, value);
        int hashedKey = hash(key);
        write(hashedKey, node);
        insertFront(node);
    }

    private void insertFront(Node node) {
        if (head == null) {
            head = node;
            tail = head;
            tail.prev = head;
        } else {
            Node newHead = node;
            newHead.next = head;
            head.prev = newHead;
            head.next = null;
            head = newHead;
        }
        ++size;
    }

    private void removeFromEnd() {
        Node newTail = tail.prev;
        newTail.next = null;
        tail = newTail;
    }

    private Node fetchNode(int hashedKey) {
        Node n = nodes[hashedKey];
        return n;
    }

    private void write(int hashedKey, Node node) {
        nodes[hashedKey] = node;
    }

    public int hash(Object key) {
        if (key == null) {
            return 0;
        }

        int position = Objects.hash(key) % nodes.length;
        if (position < 0) {
            return 0;
        }

        return position;
    }


    private class Node {
        int key;
        int value;
        int hit = 0;
        Node next;
        Node prev;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            Node that = (Node) o;
            return Objects.equals(key, that.key) && Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value) ^ Objects.hash(hit);
        }
    }
}
