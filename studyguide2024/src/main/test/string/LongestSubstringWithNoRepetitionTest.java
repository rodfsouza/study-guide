package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithNoRepetitionTest {

    @Test
    public void TestLongestSubstringWithNoRepetition() {
        LongestSubstringWithNoRepetition longestSubstringWithNoRepetition = new LongestSubstringWithNoRepetition();
        String s = "abcabcbb";
        int result = longestSubstringWithNoRepetition.maxLength(s);
        assertEquals(3, result);

        s = "bbbbb";
        result = longestSubstringWithNoRepetition.maxLength(s);
        assertEquals(1, result);

        s = "pwwkew";
        result = longestSubstringWithNoRepetition.maxLength(s);
        assertEquals(3, result);
    }
}
