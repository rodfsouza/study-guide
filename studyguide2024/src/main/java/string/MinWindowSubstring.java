package string;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int windowStart = 0;
        int windowEnd = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int counter = t.length();
        int[] charFreq = new int[128];

        for (int i = 0; i < t.length(); ++i) {
            charFreq[t.charAt(i)]++;
        }

        while (windowEnd < s.length()) {
            char c = s.charAt(windowEnd);
            if (charFreq[c] > 0) {
                counter--;
            }

            windowEnd++;
            charFreq[c]--;

            while (counter == 0) {
                if (windowEnd - windowStart < minLen) {
                    minLen = windowEnd - windowStart;
                    minStart = windowStart;
                }
                char cAtStart = s.charAt(windowStart);
                if (charFreq[cAtStart] == 0) {
                    counter++;
                }

                windowStart++;
                charFreq[cAtStart]++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
