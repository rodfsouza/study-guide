package hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtendibleHashTableTest {

    @Test
    public void testSimpleAdd() {
        ExtendibleHashTable<Integer, Integer> table = new ExtendibleHashTable<>(2);
        table.insert(1, 3);
        table.insert(2, 4);
        table.insert(3, 5);
        table.insert(4, 6);

        Assertions.assertTrue(table.get(1,3));
        Assertions.assertTrue(table.get(2,4));
        Assertions.assertTrue(table.get(3,5));
        Assertions.assertTrue(table.get(4,6));
    }
}
