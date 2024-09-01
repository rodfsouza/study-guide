package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumArrayTest {

    @Test
    public void TestNumArray() {
        int[] nums = {1, 2, 3, 4, 5};
        NumArray numArray = new NumArray(nums);
        int left = 1;
        int right = 3;
        int result = numArray.sumRange(left, right);
        int k = 9;
        assertEquals(k, result);
    }

    @Test
    public void NumArray2() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int left = 0;
        int right = 2;
        int result = numArray.sumRange(left, right);
        int k = 1;
        assertEquals(k, result);
    }
}
