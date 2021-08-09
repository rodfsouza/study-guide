package searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntevertedBinarySearchTest {

    @Test
    public void testInvertedBinarySearchIsPresent() {
        int[] a = {4,5,6,7,0,1,2};

        int isPresent = InvertedBinarySearch.search(a, 0);
        Assertions.assertEquals(4, isPresent);
    }

    @Test
    public void testInvertedBinarySearchIsNotPresent() {
        int[] a = {4,5,6,7,0,1,2};

        int isPresent = InvertedBinarySearch.search(a, 3);
        Assertions.assertEquals(-1, isPresent);
    }

    @Test
    public void testInvertedBinarySearchIsNotPresentOnlyOne() {
        int[] a = {1};

        int isPresent = InvertedBinarySearch.search(a, 0);
        Assertions.assertEquals(-1, isPresent);
    }

    @Test
    public void testInvertedBinarySearchIsPresentOnlyOne() {
        int[] a = {1};

        int isPresent = InvertedBinarySearch.search(a, 1);
        Assertions.assertEquals(0, isPresent);
    }

    @Test
    public void testInvertedBinarySearchIsPresentWithTwo() {
        int[] a = {1,3};

        int isPresent = InvertedBinarySearch.search(a, 3);
        Assertions.assertEquals(1, isPresent);
    }

    @Test
    public void testInvertedBinarySearchIsPresentWithTwoInverted() {
        int[] a = {3,1};

        int isPresent = InvertedBinarySearch.search(a, 3);
        Assertions.assertEquals(0, isPresent);
    }
}
