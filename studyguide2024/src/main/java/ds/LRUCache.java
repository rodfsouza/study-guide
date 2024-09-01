package ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> cache;

    private Node head;

    private Node tail;

    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            moveToFront(node);
        } else {
            //Overwrites the oldest entry
            if (size == capacity) {
                cache.remove(tail.key);
                remove(tail);
                size--;
            }

            Node node = new Node(key, value);
            addFront(node);
            cache.put(key, node);
            size++;
        }
    }

    private void moveToFront(Node node) {
        remove(node);
        addFront(node);
    }

    private void remove(Node toBeRemoved) {
        if (toBeRemoved.prev != null) {
            toBeRemoved.prev.next = toBeRemoved.next;
        } else {
            head = toBeRemoved.next;
        }
        if (toBeRemoved.next != null) {
            toBeRemoved.next.prev = toBeRemoved.prev;
        } else {
            tail = toBeRemoved.prev;
        }
    }

    //Adds a node to the front of the list
    private void addFront(Node toBeAdded) {
        toBeAdded.next = head;
        toBeAdded.prev = null;
        if (head != null) {
            head.prev = toBeAdded;
        }
        head = toBeAdded;
        if (tail == null) {
            tail = toBeAdded;
        }
    }
}
