package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopKFrequentElementsTest {

    @Test
    public void TestTopKFrequentElementsSuccess() {
        TopKFrequentElements top = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = top.topK(nums, 2);
        int[] expected = {1, 2};
        for (int i = 0; i < result.length; ++i) {
            assertEquals(expected[i], result[i]);
        }

        int[] nums2 = {1};
        result = top.topK(nums2, 1);
        int[] expected2 = {1};
        for (int i = 0; i < result.length; ++i) {
            assertEquals(expected2[i], result[i]);
        }
    }
}
