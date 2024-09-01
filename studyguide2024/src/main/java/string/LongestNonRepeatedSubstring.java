package string;

public class LongestNonRepeatedSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int windowStart = 0;
        int maxLength = 0;
        int[] cache = new int[256]; //ASCII

        //1. We have to walk from the begin of the string to the end
        //2. We have to keep track of the characters we have seen so far
        //3. We have to keep track of the length of the longest substring
        //4. We have to keep track of the start of the window
        //4.1 Every time we see a character we have seen before, we have to move the start of the window to the right (to the right of the last time we saw the character)
        //5. We have to keep track of the end of the window

        for (int windowEnd = 0; windowEnd < s.length(); ++windowEnd) {
            int pos = s.charAt(windowEnd);

            if (cache[pos] != 0) {
                windowStart = Math.max(windowStart, cache[pos]);
            }

            cache[pos] = windowEnd + 1;
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
