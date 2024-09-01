package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalsList = new ArrayList<>();
        boolean hasInserted = false;
        for (int[] interval : intervals) {
            //New interval is before the current interval
            if (!hasInserted && newInterval[0] < interval[0]) {
                intervalsList.add(new Interval(newInterval[0], newInterval[1]));
                hasInserted = true;
            }
            //New interval is after the current interval
            intervalsList.add(new Interval(interval[0], interval[1]));
        }

        if (!hasInserted) {
            intervalsList.add(new Interval(newInterval[0], newInterval[1]));
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        for (Interval interval : intervalsList) {
            if (!mergedIntervals.isEmpty() && interval.start <= mergedIntervals.get(mergedIntervals.size() - 1).end) {
                mergedIntervals.get(mergedIntervals.size() - 1).end =
                        Math.max(mergedIntervals.get(mergedIntervals.size() - 1).end, interval.end);
            } else {
                mergedIntervals.add(new Interval(interval.start, interval.end));
            }
        }

        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); ++i) {
            result[i][0] = mergedIntervals.get(i).start;
            result[i][1] = mergedIntervals.get(i).end;
        }

        return result;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        boolean hasInserted = false;
        for (int[] interval : intervals) {
            if (!mergedIntervals.isEmpty() && interval[0] <= mergedIntervals.get(mergedIntervals.size() - 1).end) {
                mergedIntervals.get(mergedIntervals.size() - 1).end = Math.max(mergedIntervals.get(mergedIntervals.size() - 1).end, interval[1]);
                continue;
            }

            if (!hasInserted && newInterval[0] <= interval[1]) {
                interval[0] = Math.min(newInterval[0], interval[0]);
                interval[1] = Math.max(newInterval[1], interval[1]);
                hasInserted = true;
            } else if (!hasInserted && newInterval[1] < interval[0]) {
                mergedIntervals.add(new Interval(newInterval[0], newInterval[1]));
                hasInserted = true;
            }
            mergedIntervals.add(new Interval(interval[0], interval[1]));
        }

        if (!hasInserted) {
            mergedIntervals.add(new Interval(newInterval[0], newInterval[1]));
        }

        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); ++i) {
            result[i][0] = mergedIntervals.get(i).start;
            result[i][1] = mergedIntervals.get(i).end;
        }

        return result;
    }
}
