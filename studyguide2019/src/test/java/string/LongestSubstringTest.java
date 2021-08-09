package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static string.LongestSubstring.lengthOfLongestSubstring;

public class LongestSubstringTest {

    @Test
    public void testHappyCase() {
        String one = "abcabcbb";
        String two = "bbbbb";
        String three = "pwwkew";
        String four = "tmmzuxt";

        assertEquals(3, lengthOfLongestSubstring(one));
        assertEquals(1, lengthOfLongestSubstring(two));
        assertEquals(3, lengthOfLongestSubstring(three));
        assertEquals(5, lengthOfLongestSubstring(four));
    }
}
