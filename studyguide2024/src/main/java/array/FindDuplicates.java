package array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public int find(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (seen.contains(nums[i])) {
                return nums[i];
            }
            seen.add(nums[i]);
        }
        return -1;
    }


    public int find2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int slow = 0;
        int fast = slow + 1;
        while (slow < nums.length) {
           if (nums[slow] == nums[fast]) {
               return nums[slow];
           }
           fast++;
           if (fast == nums.length) {
               slow++;
               fast = slow + 1;
           }
        }
        return -1;
    }

    public int find3(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
