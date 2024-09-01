package backtrack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SubsetsNoDupTest {

    @Test
    public void testSubsetsNoDup() {
        SubsetsNoDup s = new SubsetsNoDup();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = s.subsets(nums);

        //[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        List<Integer> exp1 = new ArrayList<>();
        List<Integer> exp2 = new ArrayList<>(Collections.singletonList(1));
        List<Integer> exp3 = new ArrayList<>(Collections.singletonList(2));
        List<Integer> exp4 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> exp5 = new ArrayList<>(Collections.singletonList(3));
        List<Integer> exp6 = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> exp7 = new ArrayList<>(Arrays.asList(2, 3));
        List<Integer> exp8 = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(exp1, exp2, exp3, exp4, exp5, exp6, exp7, exp8));

        assertArrayEquals(expected.toArray(), result.toArray());
    }
}
