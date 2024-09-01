package string;

public class LongestPalindrome {

    public String find(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); ++i) {
            int middle = expandAroundMiddle(s, i, i);
            int nextMiddle = expandAroundMiddle(s, i, i + 1);

            int lengthSoFar = Math.max(middle, nextMiddle);
            if (lengthSoFar > end - start) {
                start = i - (lengthSoFar - 1) / 2;
                end = i + lengthSoFar / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
