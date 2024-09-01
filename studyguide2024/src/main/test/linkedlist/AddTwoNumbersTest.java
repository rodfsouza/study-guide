package linkedlist;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {

    @Test
    public void addTest() {
        AddTwoNumbers operation = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = operation.add(l1, l2);
        ListNode curr = result;
        int[] expected = {7, 0, 8};

        for (int i = 0; i < 3; i++) {
            if (curr == null) {
                break;
            }
            assert curr.val == expected[i];
            curr = curr.next;
        }
    }

    @Test
    public void addTest2() {
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
        ListNode res = op.add(l1, l2);
        ListNode curr = res;
        int[] expected = {8, 9, 9, 9, 0, 0, 0, 1};

        for(int i = 0; i < 8; i++) {
            if(curr == null) {
                break;
            }
            assert curr.val == expected[i];
            curr = curr.next;
        }
    }
}
