package string;

public class LongestCommonSubsequence2 {

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
    }

    private int lcs(String text1, String text2, int len1, int len2) {

        if (len1 == text1.length() || len2 == text2.length()) {
            return 0;
        }

        if (text1.charAt(len1) == text2.charAt(len2)) {
            return 1 + lcs(text1, text2, len1 + 1, len2 + 1);
        } else {
            return Math.max(lcs(text1, text2, len1 + 1, len2), lcs(text1, text2, len1, len2 + 1));
        }
    }
}
