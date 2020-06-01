package dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumEditDistanceTest {

    @Test
    public void test1() {
        MinimumEditDistance m = new MinimumEditDistance();
        int min = m.minDistance("horse".toCharArray(), "ros".toCharArray());
        Assertions.assertEquals(3, min);
    }

    @Test
    public void test2() {
        MinimumEditDistance m = new MinimumEditDistance();
        int min = m.minDistance("intention".toCharArray(), "execution".toCharArray());
        Assertions.assertEquals(5, min);
    }
}
