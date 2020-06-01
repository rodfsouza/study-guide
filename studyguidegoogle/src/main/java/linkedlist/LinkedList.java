package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<T extends Comparable<T>> {

    SinglyNode<T> head;
    SinglyNode<T> tail;
    int size = 0;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public LinkedList(T data) {
        firstNode(data);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFront(T data) {
        if (isEmpty()) {
           firstNode(data);
        } else {
            SinglyNode newHead = new SinglyNode(data);
            newHead.next = head;
            head = newHead;
            size++;
        }
    }

    public void addLast(T data) {
        if (isEmpty()) {
            firstNode(data);
        } else {
            SinglyNode newTail = new SinglyNode(data);
            tail.next = newTail;
            tail = newTail;
            size++;
        }
    }

    private void firstNode(T data) {
        head = new SinglyNode(data);
        tail = head;
        size++;
    }

    public boolean delete(T data) {
        if (isEmpty()) {
            return false;
        }

        SinglyNode previous = head;

        if (previous.data.equals(data)) {
            head = head.next;
            return true;
        }

        while (previous.next != null) {
            if (previous.next.data.equals(data)) {
                previous.next = previous.next.next;
                return true;
            }
            previous = previous.next;
        }

        return false;
    }

    public void insertAfter(SinglyNode before, SinglyNode after) {
        if (before == null || after == null) {
            return;
        }

        SinglyNode foundBefore = search((T) before.data);
        if (foundBefore == null) {
            return;
        }

        after.next = foundBefore.next;
        foundBefore.next = after;
        before = foundBefore;
    }

    public SinglyNode search(T data) throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }

        SinglyNode current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return current;
    }

    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
    }

    public void removeDuplicates() {
        if (isEmpty()) {
            return;
        }

        SinglyNode slow = head;
        while (slow != null) {
            SinglyNode fast = slow;
            while (fast.next != null) {
                if (fast.next.data.equals(slow.data)) {
                    fast.next = fast.next.next;
                } else {
                    fast = fast.next;
                }
            }
            slow = slow.next;
        }
    }

    public void removeDups() {
        if (isEmpty()) {
            return;
        }

        SinglyNode previous = null;
        SinglyNode current = head;
        Set<Integer> seen = new HashSet<>();
        while (current != null) {
            if (seen.contains(current.data)) {
                previous.next = current.next;
            } else {
                seen.add((Integer) current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public SinglyNode kthLast(int kth) {
        if (isEmpty() || kth < 0) {
            throw new IllegalStateException();
        }
        Index idx = new Index();
        SinglyNode current = head;
        return kthLast(current, kth, idx);
    }

    private SinglyNode kthLast(SinglyNode node, int kth, Index idx) {
        if (node == null) {
            return null;
        }

        SinglyNode next = kthLast(node.next, kth, idx);
        idx.value = idx.value + 1;
        if (idx.value == kth) {
            return node;
        }
        return next;
    }

    public SinglyNode<T> sumLists(SinglyNode first, SinglyNode second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        int sum = 0;
        int carry = 0;
        SinglyNode<T> previous = new SinglyNode(0);
        SinglyNode<T> newHead = previous;

        while (first != null || second != null || carry != 0) {
            sum = (first == null ? 0 : (Integer) first.data) + (second == null ? 0 : (Integer) second.data) + carry;

            SinglyNode<T> current = new SinglyNode(sum % 10);
            carry = sum / 10;

            previous.next = current;
            previous = current;

            first = first == null ? first : first.next;
            second = second == null ? second: second.next;
        }
        return newHead.next;
    }

    public SinglyNode<T> merge(LinkedList<T> l1, LinkedList<T> l2) {
        if (l1 == null || l1.isEmpty()) {
            return l2.head;
        }

        if (l2 == null || l2.isEmpty()) {
            return l1.head;
        }

        SinglyNode<T> p2 = l2.head;
        SinglyNode<T> p1 = l1.head;
        SinglyNode<T> dummyHead = new SinglyNode(0);
        SinglyNode<T> current = dummyHead;

        while (p1 != null && p2 != null) {
            if (p1.data.compareTo(p2.data) <= 0) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        current.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }

    private class Index {
        public int value = 0;
    }
}
