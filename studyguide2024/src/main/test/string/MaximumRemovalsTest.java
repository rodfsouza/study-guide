package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumRemovalsTest {

    @Test
    public void testMaximumRemovalsSuccess() {
        MaximumRemovals maximumRemovals = new MaximumRemovals();
        String s = "abcacb";
        String p = "ab";
        int[] removable = {3, 1, 0};
        assertEquals(2, maximumRemovals.maximumRemovals(s, p, removable));
    }


}
