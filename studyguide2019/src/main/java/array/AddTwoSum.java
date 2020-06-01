package array;

public class AddTwoSum {

    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = 0;
        int size = nums.length;
        for (high = 1; high < size; ++high) {
            if (nums[low] + nums[high] == target) {
                break;
            }

            if (low < size && high < size - 1) {
                high = ++low;
            }
        }
        return new int[] {low, high};
    }
}
