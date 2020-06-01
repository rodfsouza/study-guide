package cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRUCache {

    private class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){ this.key = key; this.val = val; }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap();
        this.capacity = capacity;
        size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if(node != null){
            removeFromList(node);
            putFront(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if(node != null){
            node.val = value;
            removeFromList(node);
            putFront(node);
        }
        else if(size < capacity){ // add node to the start
            node = new Node(key, value);
            map.put(key, node);
            putFront(node);
            size++;
        }
        else{
            node = tail.prev;
            map.remove(node.key);
            node.key = key;
            node.val = value;
            map.put(key, node);
            removeFromList(node);
            putFront(node);
        }
    }

    public void putFront(Node node){
        Node temp = head.next;
        head.next = node;
        temp.prev = node;
        node.prev = head;
        node.next = temp;
    }

    public void removeFromList(Node node){
        Node tempHead = node.prev;
        Node tempTail = node.next;
        tempHead.next = tempTail;
        tempTail.prev = tempHead;
    }
}
