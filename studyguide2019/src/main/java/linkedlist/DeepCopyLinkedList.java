package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Map<Node, Node> origToCopy = new HashMap<>();
        origToCopy.put(head, new Node(head.val));

        while (current != null) {
            current = current.next;
            origToCopy.putIfAbsent(current, new Node(current.val));
        }

        for (Node orig : origToCopy.keySet()) {
            Node copy = origToCopy.get(orig);
            copy.next = origToCopy.get(orig.next);;
            copy.random = origToCopy.get(orig.random);
        }

        return origToCopy.get(head);
    }

    //https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/amp/
    public Node clone(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head, temp;

        //Insert a new node between the orig and next
        while (curr != null) {
            temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;
        //Adjust the random pointer of the newly added nodes
        while (curr != null) {
            if (curr.next != null) {
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            }

            //Move to next newly added node skipping the orig node.
            assert curr.next != null;
            curr = curr.next.next;
        }

        Node original = head, copy = head.next;

        //Saves the head of newly created list.
        temp = copy;

        //Separates the original list from the copied list.
        while (original != null) {
            original.next = original.next.next;
            assert copy != null;
            copy.next = (copy.next != null) ? copy.next.next : null;

            original = original.next;
            copy = copy.next;
        }

        return temp;
    }
}
