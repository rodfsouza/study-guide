package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTests {

    @Test
    public void testDeleteNodeAtBeginning()  {
        SinglyLinkedListNode a = new SinglyLinkedListNode(1);
        SinglyLinkedListNode b = new SinglyLinkedListNode(2);
        SinglyLinkedListNode c = new SinglyLinkedListNode(3);
        SinglyLinkedListNode d = new SinglyLinkedListNode(4);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        a.deleteNode(a);
        Assertions.assertEquals(2, a.getValue());

        SinglyLinkedListNode node = a.getNext();
        Assertions.assertEquals(3, node.getValue());

        node = node.getNext();
        Assertions.assertEquals(4, node.getValue());

        Assertions.assertNull(node.getNext());
    }

    @Test
    public void testDeleteNNodes() {
        SinglyLinkedListNode a = new SinglyLinkedListNode(1);
        SinglyLinkedListNode b = new SinglyLinkedListNode(2);
        SinglyLinkedListNode c = new SinglyLinkedListNode(3);
        SinglyLinkedListNode d = new SinglyLinkedListNode(4);
        SinglyLinkedListNode e = new SinglyLinkedListNode(3);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        SinglyLinkedListNode newHead = a.deleteNodes(3, a);
        Assertions.assertTrue(newHead != null);
    }

    @Test
    public void testMergeSorted() {

        SinglyLinkedListNode l1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode b = new SinglyLinkedListNode(2);
        SinglyLinkedListNode c = new SinglyLinkedListNode(3);
        SinglyLinkedListNode d = new SinglyLinkedListNode(4);
        //SinglyLinkedListNode e = new SinglyLinkedListNode(3);

        l1.setNext(b);
        b.setNext(c);
        c.setNext(d);
        //d.setNext(e);

        SinglyLinkedListNode l2 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode e = new SinglyLinkedListNode(3);
        SinglyLinkedListNode f = new SinglyLinkedListNode(5);
        SinglyLinkedListNode g = new SinglyLinkedListNode(7);

        l2.setNext(e);
        e.setNext(f);
        f.setNext(g);

        SinglyLinkedListNode root = new SinglyLinkedListNode(0);
        root = root.mergeSorted(l1, l2);
        Assertions.assertTrue(root != null);
    }

    @Test
    public void testInsertSortedListOnTail() {

        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode b = new SinglyLinkedListNode(2);
        SinglyLinkedListNode c = new SinglyLinkedListNode(3);
        SinglyLinkedListNode d = new SinglyLinkedListNode(4);
        //SinglyLinkedListNode e = new SinglyLinkedListNode(3);

        head.setNext(b);
        b.setNext(c);
        //c.setNext(d);
        //d.setNext(e);

        SinglyLinkedListNode root = new SinglyLinkedListNode(0);
        root = root.insertOnSorted(head, d);
        Assertions.assertTrue(root != null);
    }

    @Test
    public void testInsertSortedListOnHead() {

        SinglyLinkedListNode head = new SinglyLinkedListNode(2);
        SinglyLinkedListNode b = new SinglyLinkedListNode(3);
        SinglyLinkedListNode c = new SinglyLinkedListNode(4);
        SinglyLinkedListNode d = new SinglyLinkedListNode(1);
        //SinglyLinkedListNode e = new SinglyLinkedListNode(3);

        head.setNext(b);
        b.setNext(c);
        //c.setNext(d);
        //d.setNext(e);

        SinglyLinkedListNode root = new SinglyLinkedListNode(0);
        root = root.insertOnSorted(head, d);
        Assertions.assertTrue(root != null);
    }

    @Test
    public void testInsertSortedListOnMiddle() {

        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode b = new SinglyLinkedListNode(2);
        SinglyLinkedListNode c = new SinglyLinkedListNode(3);
        SinglyLinkedListNode d = new SinglyLinkedListNode(5);
        SinglyLinkedListNode e = new SinglyLinkedListNode(4);

        head.setNext(b);
        b.setNext(c);
        c.setNext(d);
        //d.setNext(e);

        SinglyLinkedListNode root = new SinglyLinkedListNode(0);
        root = root.insertOnSorted(head, e);
        Assertions.assertTrue(root != null);
    }

    @Test
    public void testSwapPairs() {

        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode b = new SinglyLinkedListNode(2);
        SinglyLinkedListNode c = new SinglyLinkedListNode(3);
        SinglyLinkedListNode d = new SinglyLinkedListNode(4);


        head.setNext(b);
        b.setNext(c);
        c.setNext(d);
        //d.setNext(e);

        SinglyLinkedListNode root = new SinglyLinkedListNode(0);
        root = root.swapPairs(head);
        Assertions.assertTrue(root != null);
    }

    @Test
    public void testRotateRightSuccess() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.setNext(new SinglyLinkedListNode(2));
        head.getNext().setNext(new SinglyLinkedListNode(3));
        head.getNext().getNext().setNext(new SinglyLinkedListNode(4));
        head.getNext().getNext().getNext().setNext(new SinglyLinkedListNode(5));

        SinglyLinkedListNode otherHead = head.rotateRight(head, 2);
        Assertions.assertFalse(otherHead == null);
    }

    @Test
    public void testRotateRightSuccess2() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        head.setNext(new SinglyLinkedListNode(1));
        head.getNext().setNext(new SinglyLinkedListNode(2));

        SinglyLinkedListNode otherHead = head.rotateRight(head, 4);
        Assertions.assertFalse(otherHead == null);
    }

    @Test
    public void testRotateRightSuccess3() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.setNext(new SinglyLinkedListNode(2));
        //head.getNext().setNext(new SinglyLinkedListNode(2));

        SinglyLinkedListNode otherHead = head.rotateRight(head, 1);
        Assertions.assertFalse(otherHead == null);
    }


    @Test
    public void testDeleteDuplicatedNodes() {
        SinglyLinkedListNode a = new SinglyLinkedListNode(1);
        SinglyLinkedListNode b = new SinglyLinkedListNode(2);
        SinglyLinkedListNode c = new SinglyLinkedListNode(3);
        SinglyLinkedListNode d = new SinglyLinkedListNode(3);
        SinglyLinkedListNode e = new SinglyLinkedListNode(4);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        SinglyLinkedListNode newHead = a.deleteDuplicates(a);
        Assertions.assertTrue(newHead != null);
    }

//    @Test
//    public void nodeInTheMiddleTest() {
//        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
//        SinglyLinkedListNode nodeToDelete = appendToList(head, 2);
//        appendToList(head, 3);
//        appendToList(head, 4);
//
//        deleteNode(nodeToDelete);
//
//        SinglyLinkedListNode node = head;
//        assertEquals(1, node.value);
//
//        node = node.next;
//        assertEquals(3, node.value);
//
//        node = node.next;
//        assertEquals(4, node.value);
//
//        assertNull(node.next);
//    }
}
