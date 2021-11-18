package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LongestPalindromeTest {

    private static LongestPalindrome longestPalindrome;

    @BeforeAll
    public static void init() {
        longestPalindrome = new LongestPalindrome();
    }

    @Test
    public void testComputeLongestPalindrome1() {
        String input = "aba";
        String result = longestPalindrome.compute(input);
        Assertions.assertEquals(input, result);
    }

    @Test
    public void testComputeLongestPalindrome2() {
        String input = "aaaaaa";
        String result = longestPalindrome.compute(input);
        Assertions.assertEquals(input, result);
    }

    @Test
    public void testComputeLongestPalindrome3() {
        String input = "babad";
        String result = longestPalindrome.compute(input);
        Assertions.assertEquals("aba", result);
    }

    @Test
    public void testComputeLongestPalindrome4() {
        String input = "cbbd";
        String result = longestPalindrome.compute(input);
        Assertions.assertEquals("bb", result);
    }

    @Test
    public void testComputeLongestPalindrome5() {
        String input = "a";
        String result = longestPalindrome.compute(input);
        Assertions.assertEquals("a", result);
    }

    @Test
    public void testComputeLongestPalindrome6() {
        String input = "ac";
        String result = longestPalindrome.compute(input);
        Assertions.assertEquals("c", result);
    }
}
