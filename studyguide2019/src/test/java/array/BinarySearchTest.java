package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void binarySearchTestWithRange() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assertions.assertTrue(ranges[0] == 3 && ranges[1] == 4);
    }

    @Test
    public void binarySearchTestOutOfRange() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assertions.assertTrue(ranges[0] == -1 && ranges[1] == -1);
    }

    @Test
    public void binarySearchTestEmptyNums() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{}, 0);
        Assertions.assertTrue(ranges[0] == -1 && ranges[1] == -1);
    }

    @Test
    public void binarySearchTestFindFirst() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5);
        Assertions.assertTrue(ranges[0] == 0 && ranges[1] == 0);
    }

    @Test
    public void binarySearchTestFindLast() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10);
        Assertions.assertTrue(ranges[0] == 5 && ranges[1] == 5);
    }

    @Test
    public void binarySearchTestFindRepetionRange() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{3,3,3}, 3);
        Assertions.assertTrue(ranges[0] == 0 && ranges[1] == 2);
    }

    @Test
    public void binarySearchTestFindOneRange() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{3}, 3);
        Assertions.assertTrue(ranges[0] == 0 && ranges[1] == 0);
    }

    @Test
    public void binarySearchTestFindNoRange() {
        BinarySearch bs = new BinarySearch();
        int[] ranges = bs.searchRange(new int[]{3}, 4);
        Assertions.assertTrue(ranges[0] == -1 && ranges[1] == -1);
    }
}
