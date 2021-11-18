package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMinSortedArrayTest {

    @Test
    public void findMinTest1() {
        FindMinSortedArray s = new FindMinSortedArray();
        int[] arr = new int[] {1,2,3,4};
        int min = s.findMin(arr);
        Assertions.assertEquals(1, min);
    }

    @Test
    public void findMinTest2() {
        FindMinSortedArray s = new FindMinSortedArray();
        int[] arr = new int[] {2,1};
        int min = s.findMin(arr);
        Assertions.assertEquals(1, min);
    }

    @Test
    public void findMinTest3() {
        FindMinSortedArray s = new FindMinSortedArray();
        int[] arr = new int[] {3,4,5,1,2};
        int min = s.findMin(arr);
        Assertions.assertEquals(1, min);
    }

    @Test
    public void findMinTest4() {
        FindMinSortedArray s = new FindMinSortedArray();
        int[] arr = new int[] {4,5,6,7,0,1,2};
        int min = s.findMin(arr);
        Assertions.assertEquals(0, min);
    }

    @Test
    public void findMinTest5() {
        FindMinSortedArray s = new FindMinSortedArray();
        int[] arr = new int[] {11,13,15,17};
        int min = s.findMin(arr);
        Assertions.assertEquals(11, min);
    }
}
