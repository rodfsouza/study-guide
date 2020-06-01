package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeaksAndValeysTest {

    @Test
    public void test1() {
        int[] input = {5,3,1,2,3};
        Object[] expected = {5,1,3,2,3};
        PeaksAndValeys pv = new PeaksAndValeys();
        Object[] result = pv.sort(input);
        Assertions.assertEquals(expected, result);
    }
}
