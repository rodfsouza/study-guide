package array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumTest {

    @Test
    public void ThreeSumTest() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.sum2(nums);
        List<List<Integer>> k = new ArrayList<>();
        k.add(Arrays.asList(-1, -1, 2));
        k.add(Arrays.asList(-1, 0, 1));

        assertArrayEquals(k.toArray(), result.toArray());
    }

    @Test
    public void ThreeSumTest2() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = threeSum.sum(nums);
        List<List<Integer>> k = new ArrayList<>();
        k.add(Arrays.asList(0, 0, 0));

        assertArrayEquals(k.toArray(), result.toArray());
    }

    @Test
    public void ThreeSumTest3() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {0, 1, 1};
        List<List<Integer>> result = threeSum.sum(nums);
        List<List<Integer>> k = new ArrayList<>();;

        assertArrayEquals(k.toArray(), result.toArray());
    }
}
