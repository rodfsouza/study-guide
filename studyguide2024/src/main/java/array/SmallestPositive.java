package array;

import java.util.Arrays;

public class SmallestPositive {

    public int find(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int notPresent = 1;

        while (Arrays.binarySearch(nums, notPresent) >= 0) {
            notPresent++;
        }

//        for(int i = 0; i < nums.length; i++) {
//            if (nums[i] == notPresent) {
//                notPresent++;
//            }
//        }

        return notPresent;
    }
}
