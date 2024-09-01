package linkedlist;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
