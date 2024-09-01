package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on the end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Interval overlaps with the previous one
                count++;
            } else {
                // No overlap, update end to the end of the current interval
                end = intervals[i][1];
            }
        }

        return count;
    }
}
