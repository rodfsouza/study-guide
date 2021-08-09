package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeIntervalsTest {

    @Test
    public void testMergeIntervalsSuccess() {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};

        int[][] expected = {{1,6}, {8,10}, {15,18}};
        int[][] merged = MergeIntervals.merge(a);
        validateIntervals(expected, merged);
    }

    public static boolean validateIntervals(int[][] expected, int[][] actual) {
        if (actual.length != expected.length) {
            return false;
        }

        for (int[] e : expected) {
            for (int[] a : actual) {
                if (e[0] != a[0] && e[1] != a[1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
