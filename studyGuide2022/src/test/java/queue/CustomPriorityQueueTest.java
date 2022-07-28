package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomPriorityQueueTest {

    @Test
    public void testCustomPriorityQueue() throws IllegalAccessException {
        CustomPriorityQueue<Integer> queue = new CustomPriorityQueue<>(Integer::compareTo);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(-1);
        queue.enqueue(4);

        int[] expected = {4,3,2,2,1,1,-1};
        for (int i = 0; i < queue.size(); ++i) {
            Assertions.assertEquals(expected[i], queue.dequeue());
        }
    }

    @Test
    public void testCustomPriorityQueueReversed() throws IllegalAccessException {
        CustomPriorityQueue<Integer> queue = new CustomPriorityQueue<>((a, b) -> b.compareTo(a));
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(-1);
        queue.enqueue(4);

        int[] expected = {-1,1,1,2,2,3,4};
        for (int i = 0; i < queue.size(); ++i) {
            Assertions.assertEquals(expected[i], queue.dequeue());
        }
    }
}
