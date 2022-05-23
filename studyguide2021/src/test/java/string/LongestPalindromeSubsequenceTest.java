package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LongestPalindromeSubsequenceTest {

    private static LongestPalindromeSubsequence longest;

    @BeforeAll
    public static void init() {
        longest = new LongestPalindromeSubsequence();
    }

    //@Test
    public void testLongestPalindromeSubsequence1() {
        String input = "bbbab";
        int result = longest.compute(input);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testLongestPalindromeSubsequence2() {
        String input = "bbbab";
        int result = longest.compute2(input);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testLongestPalindromeSubsequence3() {
        String input = "cbbd";
        int result = longest.compute2(input);
        Assertions.assertEquals(2, result);
    }
}
