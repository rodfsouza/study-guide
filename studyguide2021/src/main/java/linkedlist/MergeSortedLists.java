package linkedlist;

public class MergeSortedLists {

    public ListNode merge(ListNode l1, ListNode l2) {

        if (l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;

            } else {

                curr.next = p2;
                p2 = p2.next;
            }

            curr = curr.next;
        }

        curr.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }
}
