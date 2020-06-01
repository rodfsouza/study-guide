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
