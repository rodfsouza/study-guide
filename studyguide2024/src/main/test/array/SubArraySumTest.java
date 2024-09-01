package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubArraySumTest {

    @Test
    public void TestSumSubArray() {
        int[] nums = {1, 1, 1};
        int k = 2;
        SubArraySum subArray = new SubArraySum();
        int result = subArray.sum(nums, k);
        assertEquals(2, result);

        nums = new int[]{1, 2, 3};
        k = 3;
        result = subArray.sum(nums, k);
        assertEquals(2, result);
    }
}
