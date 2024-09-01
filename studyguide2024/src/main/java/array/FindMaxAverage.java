package array;

public class FindMaxAverage {

    public double maxAvg(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            double sum = 0;
            boolean notEnoughElements = false;
            for (int counter = 1, j = i; counter <= k; ++counter) {
                if (j + 1 >= nums.length && counter < k) {
                    notEnoughElements = true;
                    break;
                }
                sum += nums[j++];
            }

            if (notEnoughElements) {
                break;
            }
            maxAvg = Math.max(maxAvg, sum);
        }
        return maxAvg / k;
    }

    public double maxAvg2(int[] nums, int k) {

        //Pre Compute the sum of the first k elements
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }

        if (k == nums.length) {
            return (double) nums[nums.length - 1] / k;
        }

        double maxAvg = Integer.MIN_VALUE;
        //Iterate through the array and calculate the sum of the next k elements
        for (int i = nums.length - 1; i > k - 1; i--) {
            double currAvg;
            if (i - k + 1 == 0) {
                currAvg = nums[i];
            } else {
                currAvg = nums[i] - nums[i - k];
            }
            maxAvg = Math.max(maxAvg, currAvg / k);
        }
        return maxAvg;
    }
}
