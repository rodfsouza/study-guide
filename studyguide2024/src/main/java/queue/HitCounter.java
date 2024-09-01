package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class HitCounter {

    private final Deque<Pair<Integer, Integer>> queue;

    private int total;

    private final int LIMIT = 300;

    public HitCounter() {
        this.queue = new ArrayDeque<>();
        this.total = 0;
    }

    public void hit(int timestamp) {
        if (queue.isEmpty() || queue.getLast().getKey() != timestamp) {
            queue.add(new Pair<>(timestamp, 1));
        } else {
            Pair<Integer, Integer> last = queue.removeLast();
            queue.add(new Pair<>(last.getKey(), last.getValue() + 1));
        }
        total++;
    }

    public int getHits(int timestamp) {
        if (queue.isEmpty()) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int diff = timestamp - queue.getFirst().getKey();
            if (diff >= LIMIT) {
                total -= queue.getFirst().getValue();
                queue.removeFirst();
            } else {
                break;
            }
        }
        return total;
    }

    private class Pair<K, V> {
        K key;

        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
