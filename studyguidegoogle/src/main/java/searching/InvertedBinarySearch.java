package searching;

public class InvertedBinarySearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    private static int invertedBinarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (target == nums[mid]) {
            return mid;
        }

        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid])
                return invertedBinarySearch(nums, left + 1, mid - 1, target);
            else
                return invertedBinarySearch(nums, mid + 1, right, target);
        } else {//if (target <= nums[right]) {
            if (target < nums[right] && target > nums[mid])
                return invertedBinarySearch(nums, mid + 1, right - 1, target);
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (target < nums[mid]) {
            return binarySearch(nums, low, mid -1, target);
        } else if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return mid;
        }
    }
}
