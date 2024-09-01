package backtrack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermuteIntArrayTest {

    @Test
    public void testPermute() {
        PermuteIntArray permuteIntArray = new PermuteIntArray();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permuteIntArray.permute(nums);

        List<Integer> exp1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> exp2 = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> exp3 = new ArrayList<>(Arrays.asList(2, 1, 3));
        List<Integer> exp4 = new ArrayList<>(Arrays.asList(2, 3, 1));
        List<Integer> exp5 = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> exp6 = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(exp1, exp2, exp3, exp4, exp5, exp6));
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}
