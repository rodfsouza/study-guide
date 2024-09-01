package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesTest {

    @Test
    public void TestRemoveDuplicates() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2};
        int result = removeDuplicates.remove(nums);
        int k = 2;
        assertEquals(k, result);
    }

    @Test
    public void TestRemoveDuplicatesLarger() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates.remove(nums);
        int k = 5;
        assertEquals(k, result);
    }

    @Test
    public void TestRemoveDuplicatesEmpty() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {};
        int result = removeDuplicates.remove(nums);
        int k = -1;
        assertEquals(k, result);
    }

    @Test
    public void TestRemoveDuplicatesFull() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int result = removeDuplicates.remove(nums);
        int k = 1;
        assertEquals(k, result);
    }

    @Test
    public void TestRemoveNoDuplicates() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 2, 3};
        int result = removeDuplicates.remove(nums);
        int k = 3;
        assertEquals(k, result);
    }
}
