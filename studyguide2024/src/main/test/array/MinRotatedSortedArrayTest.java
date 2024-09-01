package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinRotatedSortedArrayTest {

    @Test
    public void testFindMin() {
        MinRotateSortedArray minRotateSortedArray = new MinRotateSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        int result = minRotateSortedArray.findMin(nums);
        assertEquals(1, result);
    }

    @Test
    public void testFindMin2() {
        MinRotateSortedArray minRotateSortedArray = new MinRotateSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = minRotateSortedArray.findMin(nums);
        assertEquals(0, result);
    }

    @Test
    public void testFindMin3() {
        MinRotateSortedArray minRotateSortedArray = new MinRotateSortedArray();
        int[] nums = {1};
        int result = minRotateSortedArray.findMin(nums);
        assertEquals(1, result);
    }

    @Test
    public void testFindMin4() {
        MinRotateSortedArray minRotateSortedArray = new MinRotateSortedArray();
        int[] nums = {11,13, 15, 17};
        int result = minRotateSortedArray.findMin(nums);
        assertEquals(11, result);
    }

    @Test
    public void testFindMin5() {
        MinRotateSortedArray minRotateSortedArray = new MinRotateSortedArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = minRotateSortedArray.findMin(nums);
        assertEquals(1, result);
    }

    @Test
    public void testFindMin6() {
        MinRotateSortedArray minRotateSortedArray = new MinRotateSortedArray();
        int[] nums = {5, 1, 2, 3, 4};
        int result = minRotateSortedArray.findMin(nums);
        assertEquals(1, result);
    }
}
