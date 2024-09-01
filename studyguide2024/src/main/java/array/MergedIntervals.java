package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergedIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<Interval> mergedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            if (!mergedIntervals.isEmpty() && interval[0] <= mergedIntervals.get(mergedIntervals.size() - 1).end) {
                mergedIntervals.get(mergedIntervals.size() - 1).end = Math.max(mergedIntervals.get(mergedIntervals.size() - 1).end, interval[1]);
            } else {
                mergedIntervals.add(new Interval(interval[0], interval[1]));
            }
        }

        int[][] result = new int[mergedIntervals.size()][2];

        for (int i = 0; i < mergedIntervals.size(); ++i) {
            result[i][0] = mergedIntervals.get(i).start;
            result[i][1] = mergedIntervals.get(i).end;
        }

        return result;
    }
}
