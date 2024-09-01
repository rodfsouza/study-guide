package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergedIntervalsTest {

    @Test
    public void TestMergedIntervalsSuccess() {
        MergedIntervals mi = new MergedIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mi.merge(intervals);
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                assertEquals(expected[i][j], result[i][j]);
            }
        }

        int[][] intervals2 = {{1, 4}, {4, 5}};
        result = mi.merge(intervals2);
        int[][] expected2 = {{1, 5}};
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                assertEquals(expected2[i][j], result[i][j]);
            }
        }
    }
}
