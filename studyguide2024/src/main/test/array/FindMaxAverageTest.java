package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaxAverageTest {

    @Test
    public void TestFindMaxAvg() {
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = findMaxAverage.maxAvg2(nums, k);
        assertEquals(12.75, result);

        nums = new int[]{5};
        k = 1;
        result = findMaxAverage.maxAvg2(nums, k);
        assertEquals(5, result);

        nums = new int[]{-1};
        result = findMaxAverage.maxAvg2(nums, k);
        assertEquals(-1, result);
    }
}
