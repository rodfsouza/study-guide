package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchRotatedArrayTest {

    @Test
    public void testSearchRotatedTrue() {
        int[] nums = {1,0,1,1,1};
        SearchRotatedArray bs = new SearchRotatedArray();
        boolean result = bs.search(nums, 0);
        Assertions.assertTrue(result);
    }
}
