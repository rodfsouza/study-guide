package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by rodsou on 7/4/17.
 */
public class StringProblems {

    public static void main(String[] args) {
//        String str = "Rodrig";
//        String str2 = "Bolo";
//        System.out.println(hasAllUniqueChars(str));
//        System.out.println(hasAllUniqueChars(str2));
//        System.out.println(isPermutation("vani", "niva"));
//        System.out.println(isPermutation("vani", "neiva"));
//
//        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
//        System.out.println(numDecodings("60890764033457890"));

        //printStairs(6);
//        System.out.println(myAtoi("-2147483648"));
//        System.out.println(myAtoi("2147483648"));
        //System.out.println(myAtoi("    10522545459"));

        for (String str : split("Hello \"Rodrigo Souza\"", ' ', '"')) {
            System.out.println(str);
        }
    }

    static boolean hasAllUniqueChars(final String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        boolean[] uniqueChar = new boolean[128]; //ASCII

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!uniqueChar[c]) {
                uniqueChar[c] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean isPermutation(final String s1, final String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            chars.add(s1.charAt(i));
        }

        for (int j = 0; j < s2.length(); j++) {
            if (!chars.contains(s2.charAt(j))) {
                return false;
            }
        }

        return true;
    }

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int max = 0;
        Map<Character, Integer> charPos = new HashMap<>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charPos.containsKey(c)) {
                j = Math.max(j, charPos.get(c) + 1);
            }
            charPos.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0')
                continue;
            else
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

        return memo[0];
    }

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    static void printStairs(int size) {
        if (size <= 0) {
            return;
        }

        String base = "";
        for (int i = 0; i < size; i++) {
            base += "#";
        }

        for (int i = 1; i <= size; i++) {
            System.out.println(String.format("%1$" + size + "s", base.substring(0, i)));
        }
    }

    public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int result = 0;
        boolean isNegative = false;
        String trimmed = str.trim();
        List<Character> invalids = new ArrayList<>();

        for (int i = 0; i < trimmed.length(); i++) {
            Character c = trimmed.charAt(i);
            if (c.equals('+') || c.equals('-')) {
                invalids.add(c);
                isNegative = c.equals('-');
                continue;
            }

            int digit = trimmed.charAt(i) - '0';

            if (digit < 0 || digit > 9) {
                break;
            }

            result = 10 * result + digit;
        }

        if (!isNegative && (result ^ Integer.MAX_VALUE) < 0) {
            return Integer.MAX_VALUE;
        }

        if (isNegative && (result ^ Integer.MIN_VALUE) > 0) {
            return Integer.MIN_VALUE;
        }

        if (invalids.size() > 1) {
            return 0;
        }

        if (isNegative) {
            result = result * -1;
        }
        return result;
    }

    public static List<String> split(final String str, final char separator, final char escape) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        final List<Integer> separators = new ArrayList<>();
        boolean isEscaped = false;

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (c.equals(escape) || isEscaped) {
                isEscaped = true;
                continue;
            }

            isEscaped = false;

            if (c.equals(separator)) {
                separators.add(i);
            }
        }

        List<String> result = new ArrayList<>();
        int lastSeparatorPosition = 0;
        for (Integer pos : separators) {
            result.add(str.substring(lastSeparatorPosition, pos));
            lastSeparatorPosition = pos;
        }

        if (lastSeparatorPosition < str.length()) {
            result.add(str.substring(lastSeparatorPosition + 1, str.length()));
        }

        return result;
    }
}
