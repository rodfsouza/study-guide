package array;

public class MinRotateSortedArray {

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);

            if (nums[left] <= nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Handle the case where the array is not rotated
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is greater than the rightmost element
            if (nums[mid] > nums[right]) {
                // Minimum element must be in the right part of the array
                left = mid + 1;
            } else {
                // Minimum element must be in the left part of the array
                right = mid;
            }
        }

        // When left == right, we've found the minimum element
        return nums[left];
    }
}
