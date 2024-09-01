package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindDuplicatesTest {

    @Test
    public void TestFindDuplicatesSuccess() {
        int[] nums = {1, 3, 4, 2, 2};
        FindDuplicates findDuplicates = new FindDuplicates();
        int result = findDuplicates.find3(nums);
        int k = 2;
        Assertions.assertEquals(k, result);
    }

    @Test
    public void TestFindDuplicatesSuccess2() {
        int[] nums = {3, 1, 3, 4, 2};
        FindDuplicates findDuplicates = new FindDuplicates();
        int result = findDuplicates.find3(nums);
        int k = 3;
        Assertions.assertEquals(k, result);
    }

    @Test
    public void TestFindDuplicatesSuccess3() {
        int[] nums = {3, 3, 3, 3, 3};
        FindDuplicates findDuplicates = new FindDuplicates();
        int result = findDuplicates.find3(nums);
        int k = 3;
        Assertions.assertEquals(k, result);
    }
}
