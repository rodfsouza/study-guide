package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetTest {

    @Test
    public void test1() {
        List<Integer> input = Arrays.asList(1,2,3);
        PowerSet p = new PowerSet();
        List<List<Integer>> result = p.subsets(input, 0);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());

        for (List<Integer> sub : result) {
            System.out.println(sub.toString());
        }
    }
}
