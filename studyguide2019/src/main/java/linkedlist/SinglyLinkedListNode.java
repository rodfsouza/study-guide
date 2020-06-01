package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedListNode {

    private int value;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    public void deleteNode (SinglyLinkedListNode nodeToDelete) {
        if (nodeToDelete == null) {
            return;
        }

        SinglyLinkedListNode prev = nodeToDelete;

        if (prev.value == nodeToDelete.value) {
            nodeToDelete.setValue(nodeToDelete.next.value);
            nodeToDelete.setNext(nodeToDelete.next.next);
            return;
        }

        while (prev.next != null) {
            if (prev.value == nodeToDelete.value) {
                prev.next = prev.next.next;
            }
            prev = prev.next;
        }
    }

    public SinglyLinkedListNode deleteNodes(int data, SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        SinglyLinkedListNode curr = head;

        while(curr != null) {
            SinglyLinkedListNode runner = curr;
            while (runner.next != null) {
                if (runner.next.value == data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
                curr = curr.next;
            }
        }
        return head;
    }
}
