package ds;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    public void testLRUCacheSuccess() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int result = lruCache.get(1);
        assert result == 1;
        lruCache.put(3, 3);
        result = lruCache.get(2);
        assert result == -1;
        lruCache.put(4, 4);
        result = lruCache.get(1);
        assert result == -1;
        result = lruCache.get(3);
        assert result == 3;
        result = lruCache.get(4);
        assert result == 4;
    }

    @Test
    public void testLRUCacheSuccess2() {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        int result = lruCache.get(2);
        assert result == 2;
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        result = lruCache.get(2);
        assert result == -1;
    }

    @Test
    public void testLRUCacheSuccess3() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        int result = lruCache.get(4);
        assert result == 4;
        result = lruCache.get(3);
        assert result == 3;
        result = lruCache.get(2);
        assert result == 2;
    }
}
