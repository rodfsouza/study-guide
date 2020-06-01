package linkedlist;

import java.util.Stack;

/**
 * Created by rodsou on 7/6/17.
 */
public class LinkedListProblems {

    public static void main(String[] args) {
        linkedlist.ListNode l1 = new linkedlist.ListNode(2);
        l1.next = new linkedlist.ListNode(4);
        l1.next.next = new linkedlist.ListNode(3);

        linkedlist.ListNode l2 = new linkedlist.ListNode(5);
        l2.next = new linkedlist.ListNode(6);
        l2.next.next = new linkedlist.ListNode(4);
        linkedlist.ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.toString());

        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse2(l1);

//        ListNode head = generateLinkedList(10);
//        ListNode sorted = sortList(head);
//
//        while (sorted !=null) {
//            System.out.print(" " + Integer.toString(sorted.val));
//            sorted = sorted.next;
//        }

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);

        ListNode newHead = removeElements(head, 6);
        System.out.println(newHead.val);
    }

    static ListNode generateLinkedList(int size) {
        ListNode prev = new ListNode((int) (Math.random() * 50) + 10);
        ListNode head = null;

        for (int i = 0; i < size; i++) {
            ListNode n = new ListNode((int) (Math.random() * 50) + 10);
            n.next = prev;
            head = prev;
            prev = n;
        }
        return head;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = (l2 == null ? 0 : l2.val) + (l1 == null ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;
    }

    static ListNode reverse2(ListNode node) {
        Stack<ListNode> st = new Stack<>();
        ListNode cur = node;
        while(cur != null) {
            st.push(cur);
            cur = cur.next;
        }

        ListNode prev = new ListNode(0);
        ListNode head = prev;
        while (!st.isEmpty()) {
            ListNode current = st.pop();
            current.next = null;
            prev.next = current;
            prev = current;
        }
        return head.next;
    }

    static ListNode reverse(ListNode head) {
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

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode n = new ListNode(0);
        ListNode p = n;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }

        if (left != null) {
            p.next = left;
        }

        if (right != null) {
            p.next = right;
        }

        return n.next;
    }

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

}
