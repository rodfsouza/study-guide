package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumSortedArrayTest {

    @Test
    public void TestTwoSumSortedArray() {
        TwoSumSortedArray twoSumSortedArray = new TwoSumSortedArray();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumSortedArray.sum(nums, target);
        int[] k = {1, 2};
        assertArrayEquals(k, result);
    }
}
