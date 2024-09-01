package linkedlist;

public class AddTwoNumbers {

    public ListNode add(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode dummyHead = prev;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode curr = new ListNode(0);
            curr.val = sum % 10;
            carry = sum / 10;
            prev.next = curr;
            prev = curr;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
