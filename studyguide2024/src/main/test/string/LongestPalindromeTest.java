package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeTest {

    @Test
    public void TestLongestPalindrome() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        assertEquals("aba", longestPalindrome.find("babad"));
        assertEquals("racecar", longestPalindrome.find("racecar"));
        assertEquals("bb", longestPalindrome.find("cbbd"));
        assertEquals("a", longestPalindrome.find("a"));
        assertEquals("c", longestPalindrome.find("ac"));
    }
}
