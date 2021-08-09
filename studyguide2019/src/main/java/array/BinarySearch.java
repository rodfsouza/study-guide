package array;

import java.util.LinkedList;
import java.util.List;

public class BinarySearch {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }

            if (target == nums[mid]) {

                int beginning = mid;
                int end = mid;

                while (beginning - 1 >= 0 && nums[beginning - 1] == target) {
                    beginning--;
                }

                while (end + 1 <= nums.length - 1 && nums[end + 1] == target) {
                    end++;
                }

                return new int[]{beginning, end};

            }
        }

        return new int[]{-1, -1};
    }


}
