package array;

public class BinarySearch {

    public boolean search(int[] nums, int target) {
        int result = binarySearch(nums, target);
        return result != -1;
    }

    public boolean searchRecursive(int[] nums, int target) {
        int result = binarySearchRecursive(nums, target, 0, nums.length - 1);
        return result != -1;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            binarySearchRecursive(nums, target, left, mid - 1);
        } else {
            binarySearchRecursive(nums, target, mid + 1, right);
        }
        return mid;
    }
}
