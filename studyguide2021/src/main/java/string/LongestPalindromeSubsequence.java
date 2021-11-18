package string;

public class LongestPalindromeSubsequence {

    /*
    This is wrong!!!!!
     */
    public int compute(String str) {

        if (str == null || str.isEmpty() || str.isBlank()) {
            return 0;
        }

        int[][] count = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); ++i) {
            count[i][i] = 1;
        }

        for (int l = 2; l <= str.length(); ++l) {

            for (int i = 1; i < str.length() - l + 1; ++i) {
                int j = i + l - 1;

                if (l == 2 && str.charAt(l) == str.charAt(i)) {
                    count[i][j] = 2;
                } else if (str.charAt(i) == str.charAt(j)) {
                    count[i][i] = count[i + 1][j - 1] + 2;
                } else {
                    count[i][j] = Math.max(count[i + 1][j], count[i][j - 1]);
                }
            }
        }

        return count[0][str.length() - 1];
    }

    public int compute2(String str) {
        return calculate(str.toCharArray(), 0, str.length());
    }

    private int calculate(char[] str, int start, int len) {
        if (len == 1) {
            return 1;
        }

        if (len == 0) {
            return 0;
        }

        if (str[start] == str[start + len - 1]) {
            return 2 + calculate(str, start + 1, len - 2);
        } else {
            return Math.max(calculate(str, start + 1, len - 1), calculate(str, start, len - 1));
        }
    }
}
