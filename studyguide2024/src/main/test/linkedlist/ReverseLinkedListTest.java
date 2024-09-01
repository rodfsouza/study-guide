package linkedlist;

import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {

    @Test
    public void TestReverseLinkedListSuccess() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode result = reverseLinkedList.reverse(head);
        ListNode expected = new ListNode(3);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(1);
        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }

    @Test
    public void TestReverseLinkedListRecursiveSuccess() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode result = reverseLinkedList.reverseRecursive(head);
        ListNode expected = new ListNode(3);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(1);
        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }
}
