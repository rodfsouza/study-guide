package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianOfTwoArraysBinarySearchTest {

    @Test
    public void testFindMedianOddNumberOfElements() {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 25, 32};
        //{1,3,7,8,9,[11],15,19,21,25,32} == 11 / 2 = 5

        MedianOfTwoArraysBinarySearch mbs = new MedianOfTwoArraysBinarySearch();
        double median = mbs.findMedian(x, y);
        Assertions.assertEquals(11.0, median);
    }

    @Test
    public void testFindMedianEvenNumberOfElements() {
        int[] x = {1, 3, 8, 9, 15, 17};
        int[] y = {7, 11, 19, 21, 25, 32};
        //{1,3,7,8,9,[11,15],17,19,21,25,32} == 12 / 2 = 6 [11 + 15] /2 = 13.0;

        MedianOfTwoArraysBinarySearch mbs = new MedianOfTwoArraysBinarySearch();
        double median = mbs.findMedian(x, y);
        Assertions.assertEquals(13.0, median);
    }

    @Test
    public void testFindMedianNotSortedElements() {
        int[] x = {1, 3, 8, 9, 15, 17};
        int[] y = {7, 11, 19, 21, 18, 25, 32};
        //{1,3,7,8,9,[11,15],17,19,21,25,32} == 12 / 2 = 6 [11 + 15] /2 = 13.0;

        MedianOfTwoArraysBinarySearch mbs = new MedianOfTwoArraysBinarySearch();
        Assertions.assertThrows(IllegalStateException.class, () -> mbs.findMedian(x, y));
    }
}
