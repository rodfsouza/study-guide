package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayMergeTest {

    @Test
    public void testMergeSortedArray() {
        int[] a = {1,2,3,4,5,6};
        int[] b = {3,4,5,6,7,8,9};

        int[] result = ArrayMerge.merge(a, b);
        Assertions.assertTrue(result.length > 0);
    }

    @Test
    public void testMergeRotatedArray() {
        int[] a = {6,5,4,3,2,1};
        int[] b = {9,8,7,6,5,4,3};

        int[] result = ArrayMerge.mergeRotated(a, b);
        Assertions.assertTrue(result.length > 0);
    }
}
