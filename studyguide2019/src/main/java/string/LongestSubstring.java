package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> cache = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); ++windowEnd) {
            char curr = s.charAt(windowEnd);

            if (cache.containsKey(curr)) {
                windowStart = Math.max(windowStart, cache.get(curr) + 1);
            }

            cache.put(curr, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    //    public static int lengthOfLongestSubstring(String s) {
//        if (s == null || s.isEmpty()) {
//            return 0;
//        }
//
//        //Map<Character, Integer> cache = new HashMap<>();
//        int[] cache = new int[256]; //ASCII
//        boolean[] visited = new boolean[256];
//        int windowStart = 0;
//        int max = 0;
//
//        for (int windowEnd = 0; windowEnd < s.length(); ++windowEnd) {
//            //char c = s.charAt(i);
//            int pos = s.charAt(windowEnd);
//            int curr = cache[pos];
//
//            //cache.containsKey(c)
//            if (visited[pos]) {
//                //cache.get(c)
//                windowStart = Math.max(windowStart, curr + 1);
//            } else {
//
//                //cache.put(c, windowEnd);
//                cache[pos] = windowEnd;
//                visited[pos] = true;
//                max = Math.max(max, windowEnd - windowStart + 1);
//            }
//        }
//        return max;
//    }
}
