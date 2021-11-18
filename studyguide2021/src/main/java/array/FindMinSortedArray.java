package array;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */

public class FindMinSortedArray {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        //If Sorted
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid - 1];
            } else if (mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else if (nums[right] >= nums[mid]) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
