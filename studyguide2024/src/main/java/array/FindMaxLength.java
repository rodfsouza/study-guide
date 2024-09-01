package array;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {

    public int find(int[] nums) {
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
