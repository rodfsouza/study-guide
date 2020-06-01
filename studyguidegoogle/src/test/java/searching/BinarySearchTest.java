package searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchIsPresent() {
        int[] a = {1,2,3,4,5,6};

        boolean isPresent = BinarySearch.isPresent(a, 7);
        Assertions.assertTrue(isPresent);
    }
}
