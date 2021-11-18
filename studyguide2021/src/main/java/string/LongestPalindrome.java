package string;

public class LongestPalindrome {

    public String compute(String str) {

        if (str == null || str.isEmpty() || str.isBlank()) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); ++i) {
            int m = expandAroundCenter(str, i, i);
            int n = expandAroundCenter(str, i, i + 1);

            int len = Math.max(m, n);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return str.substring(start, end + 1);
    }

    private int expandAroundCenter(String str, int left, int right) {
        int l = left;
        int r = right;

        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
