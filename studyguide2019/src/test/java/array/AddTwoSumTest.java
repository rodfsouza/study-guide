package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTwoSumTest {

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        AddTwoSum a = new AddTwoSum();
        int[] result = a.twoSum(nums, target);

        for (int i = 0; i < result.length; ++i) {
            assertEquals(i, result[i]);
        }
    }

    @Test
    public void test2() {
        int[] nums = {3,2,3};
        int target = 6;
        AddTwoSum a = new AddTwoSum();
        int[] result = a.twoSum(nums, target);
        assertTrue(result.length > 0);
    }
}
