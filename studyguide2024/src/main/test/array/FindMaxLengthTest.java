package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaxLengthTest {

    @Test
    public void FindMaxLength() {
        FindMaxLength findMaxLength = new FindMaxLength();
        int[] nums = {0, 1};
        int result = findMaxLength.find(nums);
        int k = 2;
        assertEquals(k, result);

        nums = new int[] {0, 1, 0};
        result = findMaxLength.find(nums);
        assertEquals(k, result);
    }
}
