package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesSortedArrayTest {

    @Test
    public void RemoveDuplicatesSuccess() {
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicatesSortedArray remDups = new RemoveDuplicatesSortedArray();
        int maxPos = remDups.removeDuplicates(nums);
        Assertions.assertEquals(5, maxPos);
    }

    @Test
    public void RemoveDuplicatesSuccess2() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesSortedArray remDups = new RemoveDuplicatesSortedArray();
        int maxPos = remDups.removeDuplicates(nums);
        Assertions.assertEquals(7, maxPos);
    }

    @Test
    public void RemoveDuplicatesSuccess3() {
        int[] nums = {1,2,3};
        RemoveDuplicatesSortedArray remDups = new RemoveDuplicatesSortedArray();
        int maxPos = remDups.removeDuplicates(nums);
        Assertions.assertEquals(3, maxPos);
    }
}
