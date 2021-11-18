package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceTest {

    private static LongestCommonSubsequence lcs;

    @BeforeAll
    public static void init() {
        lcs = new LongestCommonSubsequence();
    }

    @Test
    public void testLongestCommonSub1() {
        String text1 = "bl";
        String text2 = "yby";

        int res = lcs.longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(1, res);
    }

    @Test
    public void testLongestCommonSub2() {
        String text1 = "abcde";
        String text2 = "cde";

        int res = lcs.longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(3, res);
    }

    @Test
    public void testLongestCommonSub3() {
        String text1 = "abc";
        String text2 = "abc";

        int res = lcs.longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(3, res);
    }

    @Test
    public void testLongestCommonSub4() {
        String text1 = "abc";
        String text2 = "def";

        int res = lcs.longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(0, res);
    }

    @Test
    public void testLongestCommonSub5() {
        String text1 = "psnw";
        String text2 = "vozsh";

        int res = lcs.longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(1, res);
    }

    @Test
    public void testLongestCommonSub6() {
        String text1 = "ezupkr";
        String text2 = "ubmrapg";

        int res = lcs.longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(2, res);
    }
}
