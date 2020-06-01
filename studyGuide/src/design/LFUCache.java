package design;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LFUCache {

    private int capacity;

    private PriorityQueue<CacheItem> items;
    private Map<Integer, CacheItem> cacheMap;

    public LFUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.items = new PriorityQueue<>(capacity);
        this.cacheMap = new TreeMap<>((o1, o2) -> (Integer) o1.compareTo(o2));
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            CacheItem toBeReturned = cacheMap.get(key);
            toBeReturned.frequency++;
            items.remove(toBeReturned);
            items.offer(toBeReturned);
            return toBeReturned.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (items.size() < capacity) {
            if (!cacheMap.containsKey(key)) {
                CacheItem item = new CacheItem(key, value);
                cacheMap.put(key, item);
                items.offer(item);
            }
        } else {
            CacheItem toBeInserted = new CacheItem(key, value);
            CacheItem item = items.poll();
            cacheMap.remove(item.key);
            cacheMap.put(key, toBeInserted);
            items.offer(toBeInserted);
        }
    }

    public class CacheItem implements Comparable {

        protected int key;
        protected int value;
        protected Integer frequency;

        public CacheItem(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 0;
        }

        @Override
        public int compareTo(Object o) {
            CacheItem that = (CacheItem) o;
            return ((Integer) this.frequency).compareTo(that.frequency);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        System.out.println(cache.get(2));
        cache.put(0, 0);
        cache.get(0);
        System.out.println(cache.get(0));
    }
}