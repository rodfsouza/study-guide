package array;

import java.text.DecimalFormat;

public class ArrayProblems {

    public static void main(String args[]) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        int[] arr = {1,12,-5,-6,50,3};
        DecimalFormat format = new DecimalFormat("#0.00");
        System.out.println(format.format(findMaxAverage(arr, 4)));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    static double findMaxAverage(int[] nums, int k) {
        int curr = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            curr += nums[i];
            if(i - k  >= 0)
                curr -= nums[i-k];
            if(i >= k-1)
                max = Math.max(curr,max);
        }
        return (double) max / k;
    }
}
