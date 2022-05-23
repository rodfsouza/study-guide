package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class MaxCircularLinkedListTest {

    @Test
    public void testMaxCircularLinkedList() throws IllegalAccessException {
        MaxCircularLinkedList queue = new MaxCircularLinkedList();
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
    public void testIteratorMaxCircularLinkedList() {
        MaxCircularLinkedList queue = new MaxCircularLinkedList();
        queue.add(1);
        queue.add(3);
        queue.add(2);

        for (Iterator<SinglyListNode> it = queue.iterator(); it.hasNext(); ) {
            SinglyListNode n = it.next();
            System.out.println(n.data);
        }
    }
}
