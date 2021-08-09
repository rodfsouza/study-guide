package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MergeIntervals {

    //{{1,3},{2,6},{8,10},{15,18}};
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Deque<int[]> merged = new ArrayDeque<>();

        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.peek()[1] < interval[0]) { //curr:[2,6], pop:[1,3]: 3 < 2
                merged.push(interval);
            } else {
                merged.peek()[1] = Math.max(merged.peek()[1], interval[1]); //Updates the index 1: pop[1]:3, interval[1]:6
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
