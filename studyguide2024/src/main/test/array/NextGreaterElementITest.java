package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextGreaterElementITest {

    @Test
    public void TestNextGreaterSuccess() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        int[] result = nextGreaterElementI.find(nums1, nums2);
        int[] k = {-1, 3, -1};
        assertArrayEquals(k, result);
    }
}
