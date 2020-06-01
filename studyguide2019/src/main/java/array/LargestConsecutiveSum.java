package array;

public class LargestConsecutiveSum {

    public static int largestSum(int[] arr) {
        if (arr == null || arr.length ==0) {
            return 0;
        }

        int max = 0;
        int current = 0;
        for (int i = 0; i < arr.length; ++i) {
            current = arr[i] + current;

            if (current < 0) {
                current = 0;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
