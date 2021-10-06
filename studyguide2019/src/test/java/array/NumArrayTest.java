package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumArrayTest {

    @Test
    public void testNumArray1() {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray obj = new NumArray(nums);
        Assertions.assertEquals(1 ,obj.sumRange(0,2));
        Assertions.assertEquals(-1, obj.sumRange(2,5));
        Assertions.assertEquals(-3, obj.sumRange(0,5));
    }
}
