package array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    //[1,1,1], k = 2
    //[1,2,3], k = 3
    public int sum(int[] nums, int k) {
        int sum = 0;
        int numSubArrays = 0;
        Map<Integer, Integer> numberOfOccurrences = new HashMap<>();
        numberOfOccurrences.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (numberOfOccurrences.containsKey(sum - k)) {
                numSubArrays += numberOfOccurrences.get(sum - k);
            }
            numberOfOccurrences.put(sum, numberOfOccurrences.getOrDefault(sum, 0) + 1);
        }
        return numSubArrays;
    }
}
