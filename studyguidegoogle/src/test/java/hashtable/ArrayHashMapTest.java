package hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayHashMapTest {

    @Test
    public void testHashMapPutWithCollisions() {
        ArrayHashMap<Integer, String> map = new ArrayHashMap<>(3);

        for (int i = 0; i < 100; ++i) {
            map.put(i, "aaaaaaa" + i);
        }

        Assertions.assertNotNull(map);
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    public void testHashMapGetWithCollisions() {
        ArrayHashMap<Integer, String> map = new ArrayHashMap<>();

        for (int i = 0; i < 100; ++i) {
            map.put(i, "aaaaaaa" + i);
        }

        Assertions.assertNotNull(map);
        Assertions.assertFalse(map.isEmpty());

        Assertions.assertTrue(map.containsKey(43));

        String value = map.get(95);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testHashMapPutNoCollision() {
        ArrayHashMap<Integer, String> map = new ArrayHashMap<>(100);

        for (int i = 0; i < 100; ++i) {
            map.put(i, "aaaaaaa" + i);
        }

        Assertions.assertNotNull(map);
        Assertions.assertFalse(map.isEmpty());
    }
}
