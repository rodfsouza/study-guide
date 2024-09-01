package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonOverlappingIntervalsTest {

    @Test
    public void testEraseOverlapIntervals() {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        assertEquals(1, result);
    }

    @Test
    public void TestEraseOverlapIntervals2() {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        assertEquals(2, result);
    }

    @Test
    public void TestEraseOverlapIntervals3() {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int[][] intervals = {{1, 2}, {2, 3}};
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        assertEquals(0, result);
    }
}
