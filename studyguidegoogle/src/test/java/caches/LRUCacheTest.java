package caches;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    LRUCache lru;

    @BeforeEach
    public void setup() {
        lru = new LRUCache(2);
    }

    @Test
    public void testPutAndGet() {
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
    }
}
