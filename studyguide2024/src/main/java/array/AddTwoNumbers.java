package array;

public class AddTwoNumbers {

    public int[] add(int[] nums, int target) {
        int low = 0;
        int high = 1;
        int size = nums.length;
        while (high < size) {
            if (nums[low] + nums[high] == target) {
                break;
            } else if (high < size - 1) {
                high++;
            } else if (high == size - 1 && low < size - 1) {
                low++;
                high = low + 1;
            }
        }
        return new int[] {low, high};
    }
}
