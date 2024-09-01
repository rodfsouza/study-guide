package array;

import java.util.Stack;

public class RemoveDuplicates {

    //{0,0,1,1,1,2,2,3,3,4}
    //i = 0
    //j = 0
    //stack.pop -> 0
    //
    public int remove(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int j = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
