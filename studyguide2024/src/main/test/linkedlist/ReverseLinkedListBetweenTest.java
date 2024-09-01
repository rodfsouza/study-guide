package linkedlist;

import org.junit.jupiter.api.Test;

public class ReverseLinkedListBetweenTest {

    @Test
    public void TestReverseBetweenSuccess() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;
        ReverseLinkedListBetween r = new ReverseLinkedListBetween();
        ListNode result = r.reverseBetween(head, left, right);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(2);
        expected.next.next.next.next = new ListNode(5);

        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }

    @Test
    public void TestReverseBetweenSuccess2() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);

        int left = 1;
        int right = 2;
        ReverseLinkedListBetween r = new ReverseLinkedListBetween();
        ListNode result = r.reverseBetween(head, left, right);

        ListNode expected = new ListNode(5);
        expected.next = new ListNode(3);

        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }

    @Test
    public void TestReverseBetweenSameSuccess() {
        ListNode head = new ListNode(5);
        int left = 1;
        int right = 1;
        ReverseLinkedListBetween r = new ReverseLinkedListBetween();
        ListNode result = r.reverseBetween(head, 1, 1);

        ListNode expected = new ListNode(5);

        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }

    @Test
    public void TestReverseBetweenSameOnePassSuccess() {
        ListNode head = new ListNode(5);
        int left = 1;
        int right = 1;
        ReverseLinkedListBetween r = new ReverseLinkedListBetween();
        ListNode result = r.reverseBetween3(head, 1, 1);

        ListNode expected = new ListNode(5);

        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }

    @Test
    public void TestReverseBetweenOnePassSuccess() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;
        ReverseLinkedListBetween r = new ReverseLinkedListBetween();
        ListNode result = r.reverseBetween3(head, left, right);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(2);
        expected.next.next.next.next = new ListNode(5);

        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }

    @Test
    public void TestReverseBetweenOnePassSuccess2() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);

        int left = 1;
        int right = 2;
        ReverseLinkedListBetween r = new ReverseLinkedListBetween();
        ListNode result = r.reverseBetween3(head, left, right);

        ListNode expected = new ListNode(5);
        expected.next = new ListNode(3);

        while (result != null) {
            assert result.val == expected.val;
            result = result.next;
            expected = expected.next;
        }
    }
}
