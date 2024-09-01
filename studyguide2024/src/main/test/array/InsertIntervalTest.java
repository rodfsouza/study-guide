package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertIntervalTest {

    @Test
    public void TestInsertIntervalSuccess() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        InsertInterval insert = new InsertInterval();
        int[][] result = insert.insert(intervals, newInterval);
        int[][] expected = {{1, 5}, {6, 9}};
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                assertEquals(expected[i][j], result[i][j]);
            }
        }
    }

    @Test
    public void TestInsertIntervalSuccess2() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        InsertInterval insert = new InsertInterval();
        int[][] result = insert.insert(intervals, newInterval);
        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                assertEquals(expected[i][j], result[i][j]);
            }
        }
    }

    @Test
    public void TestInsertIntervalSuccess3() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 0};
        InsertInterval insert = new InsertInterval();
        int[][] result = insert.insert(intervals, newInterval);
        int[][] expected = {{0,0}, {1, 5}};
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                assertEquals(expected[i][j], result[i][j]);
            }
        }
    }
}
