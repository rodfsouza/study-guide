package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithNoRepetition {

    public int maxLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;
        Map<Character, Integer> seen = new HashMap<>();

        while (windowEnd < s.length()) {
            char c = s.charAt(windowEnd);
            if (seen.containsKey(c)) {
                windowStart = Math.max(windowStart, seen.get(c) + 1);
            }
            seen.put(c, windowEnd);
            windowEnd++;
            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }
        return maxLength;
    }
}
