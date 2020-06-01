package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static array.LargestConsecutiveSum.largestSum;

public class LargestConsecutiveSumTest {

    @Test
    public void testHappyCase() {
        int[] arr = {-1, 2, 4, -7, 8, -2, 3};
        Assertions.assertEquals(9, largestSum(arr));
    }

    @Test
    public void testNegativeCase() {
        int[] arr = {-4, -5, -1, -2, -6};
        int actual = largestSum(arr);
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void testCaseAllOnes() {
        int[] arr = {1, 1, 1, 1, 1, 1, 1};
        int actual = largestSum(arr);
        Assertions.assertEquals(7, actual);
    }

    @Test
    public void testCaseAlmostEverythingNegative() {
        int[] arr = {-4, -5, -1, -2, -6, 2};
        int actual = largestSum(arr);
        Assertions.assertEquals(2, actual);
    }

    @Test
    public void testCaseInvalidArray() {
        int[] arr = null;
        int actual = largestSum(arr);
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void testCaseUnconventional() {
        int[] arr = {1, 0, -1};
        int actual = largestSum(arr);
        Assertions.assertEquals(1, actual);
    }
}
