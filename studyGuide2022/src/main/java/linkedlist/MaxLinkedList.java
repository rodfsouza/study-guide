package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxCircularLinkedList {

    private SinglyListNode head;
    private SinglyListNode tail;

    private int size;

    public MaxCircularLinkedList() {
        this.size = 0;
    }

    public void add(int data) {
        SinglyListNode node = new SinglyListNode(data);

        if (head == null) {
            head = node;
            head.next = tail;
            size++;
            return;
        }

        SinglyListNode cur = head;
        SinglyListNode prev = null;
        boolean inserted = false;

        while (cur != null) {
            if (node.data >= cur.data) {
                if (prev != null) { //If node happens to be in the middle
                    node.next = prev.next;
                    prev.next = node;
                } else { //If node is always appended in the front
                    node.next = cur;
                    cur = node;
                    head = cur;
                }
                inserted = true;
            }
            if (inserted) {
                size++;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        if (cur == null) { //If the item is smallest of the actual ones on the list
            cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            tail = node;
            cur.next = tail;
            size++;
        }
    }

    public int peek() throws IllegalAccessException {
        if (head == null) {
            throw new IllegalAccessException();
        }
        return  head.data;
    }

    public int last() throws IllegalAccessException {
        if (tail == null) {
            throw  new IllegalAccessException();
        }
        return  tail.data;
    }

    public int size() {
        return size;
    }

    public Iterator<SinglyListNode> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<SinglyListNode> {

        Itr() {
            curr = head;
        }

        SinglyListNode curr;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public SinglyListNode next() {
            SinglyListNode tmp = curr;
            curr = curr.next;
            return tmp;
        }
    }
}
