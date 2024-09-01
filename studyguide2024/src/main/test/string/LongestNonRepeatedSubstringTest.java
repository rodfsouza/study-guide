package string;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LongestNonRepeatedSubstringTest {
    private static LongestNonRepeatedSubstring longestNonRepeatedSubstring;

    @BeforeAll
    public static void init() {
        longestNonRepeatedSubstring = new LongestNonRepeatedSubstring();
    }
    @Test
    public void testLengthOfLongestSubstring() {
        String s = "abcabcbb";
        int result = longestNonRepeatedSubstring.lengthOfLongestSubstring(s);
        assert result == 3 : "Test failed";
    }

    @Test
    public void testLengthOfLongestSubstring2() {
        String s = "bbbbbb";
        int result = longestNonRepeatedSubstring.lengthOfLongestSubstring(s);
        assert result == 1 : "Test failed";
    }

    @Test
    public void testLengthOfLongestSubstring3() {
        String s = "pwwkew";
        int result = longestNonRepeatedSubstring.lengthOfLongestSubstring(s);
        assert result == 3 : "Test failed";
    }
}
