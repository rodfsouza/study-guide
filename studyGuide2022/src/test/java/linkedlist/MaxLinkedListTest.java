package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class MaxLinkedListTest {

    @Test
    public void testMaxLinkedList() throws IllegalAccessException {
        MaxLinkedList queue = new MaxLinkedList();
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(2);
        queue.add(1);
        queue.add(-1);
        queue.add(4);
        Assertions.assertEquals(7, queue.size());
        Assertions.assertEquals(4, queue.peek());
        Assertions.assertEquals(-1, queue.last());
    }

    @Test
    public void testIteratorMaxLinkedList() {
        MaxLinkedList queue = new MaxLinkedList();
        queue.add(1);
        queue.add(3);
        queue.add(2);

        for (Iterator<SinglyListNode> it = queue.iterator(); it.hasNext(); ) {
            SinglyListNode n = it.next();
            System.out.println(n.data);
        }
    }
}
