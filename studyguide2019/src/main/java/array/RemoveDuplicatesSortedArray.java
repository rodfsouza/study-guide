package array;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicatesSortedArray {

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        //int maxRange = nums[nums.length - 1];
        int[] reps = new int[nums.length];
        for (int i = 0; i < reps.length; ++i) {
            reps[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < reps.length; ++i) {
            int item = reps[i];
            int maxReps = 0;

            while (maxReps++ < 2 && item-- > 0) {
                nums[j] = i;
                j++;
            }
        }

        return j;
    }

    public int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> dupCount = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int itemKey = nums[i];

            if (dupCount.containsKey(itemKey)) {
                int currValue = dupCount.get(itemKey);
                currValue++;
                dupCount.put(itemKey, currValue);
            } else {
                dupCount.put(itemKey, 1);
            }
        }

        int maxCurrPos = 0;
        for (int key : dupCount.keySet()) {
            int itemValue = dupCount.get(key);
            int maxReps = 0;

            while (maxReps++ < 2 && itemValue-- > 0) {
                nums[maxCurrPos] = key;
                maxCurrPos++;
            }
        }

        return maxCurrPos;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int appears = 1;
        int left = 1, right = 1;
        while (right < nums.length) {

            if (nums[right] == nums[left - 1] && appears < 2) {
                nums[left++] = nums[right];
                appears++;
            } else if (nums[right] != nums[left - 1]) {
                nums[left++] = nums[right];
                appears = 1;
            }

            right++;
        }
        return left;
    }


}
