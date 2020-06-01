package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> cache = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (cache.containsKey(c)) {
                j = Math.max(j, cache.get(c) + 1);
            }
            cache.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
