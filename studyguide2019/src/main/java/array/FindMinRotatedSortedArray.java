package array;

public class FindMinRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // Edge Case: 1 2 3 4 5
        if(nums[left] <= nums[right])
            return nums[left];

        while(left <= right){
            int mid = (left + right) / 2; //Trick

            if(nums[mid] > nums[mid + 1])  // Edge Case: 5 1 2 3 4
                return nums[mid + 1];
            else if(nums[mid] < nums[mid - 1])
                return nums[mid];
            else if(nums[left] <= nums[mid])
                left = mid + 1;
            else if(nums[mid] <= nums[right])
                right = mid - 1;
        }
        return -1;
    }
}
