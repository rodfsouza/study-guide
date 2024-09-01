package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementTest {

    @Test
    public void TestKthLargestElementSuccess() {
        KthLargestElement kth = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int result = kth.find(nums, 2);
        assertEquals(5, result);

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        result = kth.find(nums2, 4);
        assertEquals(4, result);
    }
}
