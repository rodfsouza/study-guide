package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static linkedlist.AddTwoNumbers.*;

public class AddTwoNumberTest {

    @Test
    public void testSumTwoNumbersSuccess() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers op = new AddTwoNumbers();
        ListNode result = op.add(l1, l2);
        Assertions.assertFalse(result == null);
    }

    @Test
    public void testSumTwoNumbersOneBiggerListSuccess() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        AddTwoNumbers op = new AddTwoNumbers();
        ListNode result = op.add(l1, l2);
        Assertions.assertFalse(result == null);
    }
}
