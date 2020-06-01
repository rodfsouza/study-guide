package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class LinkedListTest {

    @Test
    public void testSumList() {
        LinkedList<Integer> first = new LinkedList<>(7);
        first.addLast(1);
        first.addLast(6);

        LinkedList<Integer> second = new LinkedList<>(5);
        second.addLast(9);
        second.addLast(2);

        SinglyNode node = first.sumLists(first.head, second.head);
        Assertions.assertNotNull(node);

        SinglyNode current = node;
        String strNumber = "";
        while (current != null) {
            strNumber += current.data;
            current = current.next;
        }

        String temp = "";
        for (int i = strNumber.length() - 1; i >= 0; i--) {
            temp += Character.toString(strNumber.charAt(i));
        }

        Assertions.assertEquals("912", temp);
    }

    @Test
    public void testSumListDifferentSizes() {
        LinkedList<Integer> first = new LinkedList<>(5);
        first.addLast(2);
        first.addLast(5);

        LinkedList<Integer> second = new LinkedList<>(5);
        second.addLast(2);

        SinglyNode node = first.sumLists(first.head, second.head);
        Assertions.assertNotNull(node);
    }


    @Test
    public void testSearch() {
        LinkedList<Integer> first = new LinkedList<>(0);
        first.addFront(5);
        first.addFront(1);

        SinglyNode node = first.search(5);
        Assertions.assertNotNull(node);
        Assertions.assertEquals(5, node.data);
    }

    @Test
    public void testInsertAfter() {
        LinkedList<Integer> before = new LinkedList<>(0);
        before.addFront(5);
        before.addFront(1);

        SinglyNode after = new SinglyNode(6);
        before.insertAfter(before.head, after);
    }

    @Test
    public void testRemoveDuplicates() {
        LinkedList<Integer> first = new LinkedList<>(5);
        first.addLast(2);
        first.addLast(5);
        first.addFront(3);

        first.removeDuplicates();
    }

    @Test
    public void testRemoveDups() {
        LinkedList<Integer> first = new LinkedList<>(5);
        first.addLast(2);
        first.addLast(5);
        first.addFront(3);

        first.removeDups();
    }

    @Test
    public void testDelete() {
        LinkedList<Integer> first = new LinkedList<>(5);
        first.addLast(2);
        first.addLast(5);
        first.addFront(3);

        boolean result = first.delete(2);
        Assertions.assertTrue(result);
    }
    @Test
    public void testHasCycle() {
        SinglyNode<Character> a = new SinglyNode<>('A');
        SinglyNode<Character> b = new SinglyNode<>('B');
        SinglyNode<Character> c = new SinglyNode<>('C');
        SinglyNode<Character> d = new SinglyNode<>('D');
        SinglyNode<Character> e = new SinglyNode<>('E');

        //weaving
        addToList(a, b);
        addToList(b, c);
        addToList(c, d);
        addToList(d, e);
        addToList(e, c);

        SinglyNode cycle = a.hasCycle(a);
        Assertions.assertNotNull(cycle);
        Assertions.assertEquals('C', cycle.data);
    }

    private void addToList(SinglyNode tail, SinglyNode node) {
        tail.next = node;
    }

    @Test
    public void testMerge() {
        LinkedList<Integer> first = new LinkedList<>(1);
        first.addLast(6);
        first.addLast(7);

        LinkedList<Integer> second = new LinkedList<>(2);
        second.addLast(5);
        second.addLast(9);

        SinglyNode node = first.merge(first, second);
        Assertions.assertNotNull(node);
    }

    @Test
    public void testKthLast() {
        LinkedList<Integer> first = new LinkedList<>(1);
        first.addLast(6);
        first.addLast(7);
        first.addLast(3);
        first.addLast(5);

        SinglyNode node = first.kthLast(3);
        Assertions.assertNotNull(node);
        Assertions.assertEquals(7, node.data);
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;
        PriorityQueue<Integer> inOrderQueue = new PriorityQueue<>();

        for (int i = 0; i < lists.length; ++i) {
            ListNode current = lists[i];
            while (current != null) {
                inOrderQueue.add(current.val);
                current = current.next;
            }
        }

        while (!inOrderQueue.isEmpty()) {
            int currentVal = inOrderQueue.poll();
            pointer.next = new ListNode(currentVal);
            pointer = pointer.next;
        }

        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 ) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);

        for (int i = 0; i < lists.length; ++i) {
            merge(lists[i], dummyHead);
        }
        return dummyHead.next;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode merged = new ListNode(0);
        ListNode p = merged;

        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else if (left.val == right.val) {

                while (left.val == right.val) {
                    p.next = left;
                    left = left.next;
                    right = right.next;
                }

            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }

        p.next = left != null ? left : right;
        return merged.next;
    }


    @Test
    public void reverKGroup() {
        ListNode node = buildList(5);
        ListNode reverse = reverseKGroup2(node, 2);
        Assertions.assertNotNull(reverse);
    }

    private ListNode buildList(int k) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (int i = 1; i <= k; ++i) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        return head.next;
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        //Find the node
        while (current != null && current.val != k) {
            prev = current;
            current = current.next;
        }

        //Swap
        ListNode oldHead = head;
        head = current;

        return head;
    }

    private ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int num = 0;
        ListNode preHeader = new ListNode(-1);
        preHeader.next = head;
        ListNode cur = preHeader, nex, pre = preHeader;

        while (cur != null && cur.val != k) {
            cur = cur.next;
            num++;
        }

        while (num >= k) {
            cur = pre.next;
            nex = cur.next;

            for (int i = 1; i < k; ++i) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            num-=k;
        }
        return preHeader.next;
    }
}

