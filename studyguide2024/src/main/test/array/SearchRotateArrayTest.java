package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchRotateArrayTest {

    @Test
    public void testSearchRotatedArray() {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = searchRotateArray.search(nums, target);
        assertEquals(4, result);
    }

    @Test
    public void testSearchRotatedArray2() {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int result = searchRotateArray.search(nums, target);
        assertEquals(-1, result);
    }

    @Test
    public void testSearchRotatedArray3() {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] nums = {1};
        int target = 0;
        int result = searchRotateArray.search(nums, target);
        assertEquals(-1, result);
    }
}
