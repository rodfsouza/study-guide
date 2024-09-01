package array;

import array.SmallestPositive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestPositiveTest {
    @Test
    public void testFind() {
        SmallestPositive smallestPositive = new SmallestPositive();
        assertEquals(3, smallestPositive.find(new int[]{1, 2, 0}));
        assertEquals(2, smallestPositive.find(new int[] {3, 4, -1, 1}));
        assertEquals(1, smallestPositive.find(new int[] {7, 8, 9, 11, 12}));
        assertEquals(4, smallestPositive.find(new int[] {0, 1, 2, 3}));
    }
}