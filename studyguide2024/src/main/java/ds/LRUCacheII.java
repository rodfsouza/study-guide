package ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheII {

    private final LinkedList<Integer> items;

    private final Map<Integer, ValuePosition> itemToPosition;

    private final int capacity;

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        this.items = new LinkedList<>();
        this.itemToPosition = new HashMap<>();
    }

    public int get(int key) {
        if (!itemToPosition.containsKey(key)) {
            return -1;
        }
        int position = itemToPosition.get(key).position;
        items.remove(position);
        items.addFirst(key);
        itemToPosition.put(key, new ValuePosition(itemToPosition.get(key).value, 0));
        return key;
    }

    public void put(int key, int value) {
        if (!itemToPosition.containsKey(key)) {
            if (items.size() == capacity) {
                int last = items.removeLast();
                itemToPosition.remove(last);
            }
        } else {
            int position = itemToPosition.get(key).position;
            items.remove(position);
        }
        items.addFirst(key);
        itemToPosition.put(key, new ValuePosition(value, 0));

    }

    private static class ValuePosition {
        int value;
        int position;

        public ValuePosition(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
}
