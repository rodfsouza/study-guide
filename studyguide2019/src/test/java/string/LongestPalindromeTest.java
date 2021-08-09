package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestPalindromeTest {

    @Test
    public void test1() {
        String input = "babad";
        String expected = "bab";

        LongestPalindrome lp = new LongestPalindrome();
        String res = lp.longestPalindrome(input);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void test2() {
        String input = "cbbd";
        String expected = "bb";

        LongestPalindrome lp = new LongestPalindrome();
        String res = lp.longest(input);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void test3() {
        String input = "bb";
        String expected = "bb";

        LongestPalindrome lp = new LongestPalindrome();
        String res = lp.longestPalindrome(input);
        Assertions.assertEquals(expected, res);
    }
}
