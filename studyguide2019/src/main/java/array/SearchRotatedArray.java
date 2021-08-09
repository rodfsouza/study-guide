package array;

public class SearchRotatedArray {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return true;
            }

            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) { //&& target >= nums[left]
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) { //&& target <= nums[right]
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
