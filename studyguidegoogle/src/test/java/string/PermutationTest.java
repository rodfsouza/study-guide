package string;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PermutationTest {

    @Test
    public void testStringPermutation() {
        Permutation p = new Permutation();
        List<String> permutations = p.permute("abcd");

        for (String s : permutations) {
            System.out.print(String.format("{%s} ",s));
        }
    }
}
