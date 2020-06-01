package string;

import org.junit.jupiter.api.Test;

public class SubstringPermutationTest {

    @Test
    public void test1() {
        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";
        SubstringPermutation sp = new SubstringPermutation();
        sp.printPermutations(s, b);
    }
}
