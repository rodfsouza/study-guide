package queue;

import org.junit.jupiter.api.Test;
import queue.MaxCircularQueue;

public class MaxCircularQueueTest {

    @Test
    public void testMaxCircularQueue() {
        int[] arr = new int[5];
        MaxCircularQueue queue = new MaxCircularQueue();
        queue.add(arr, 1);
        queue.add(arr, 3);
        queue.add(arr, 2);
        queue.add(arr, 2);
        queue.add(arr, 1);
        queue.add(arr, -1);
        queue.add(arr, 4);
    }
}
