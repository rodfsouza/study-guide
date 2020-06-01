package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StairsTest {

    @Test
    public void test1() {
        int input = 5;
        int expected = 13;
        Stairs st = new Stairs();
        int result = st.countWays(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test2() {
        int input = -1;
        int expected = 0;
        Stairs st = new Stairs();
        int result = st.countWays(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test3() {
        int input = 0;
        int expected = 1;
        Stairs st = new Stairs();
        int result = st.countWays(input);
        Assertions.assertEquals(expected, result);
    }
}
