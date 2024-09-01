package array;

public class TwoSumSortedArray {

    public int[] sum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[] {0, 0};
    }
}
