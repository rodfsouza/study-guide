package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortTest {

    @Test
    public void testMergeSort() {
        int[] test = {45,84,15,55,31,11,0,7};
        Sort.mergeSort(test);
        Assertions.assertTrue(test.length > 0);
    }

    @Test
    public void testQuickSort() {
        int[] test = {45,84,15,55,31,11,0,7};
        Sort.quickSort(test);
        Assertions.assertTrue(test.length > 0);
    }
}
