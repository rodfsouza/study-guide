package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PermutationTests {

    @Test
    public void test1() {
        Permutation p = new Permutation();
        String input = "cats";
        List<String> res = p.permute(input);
        Assertions.assertNotNull(res);
    }
}
