package integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTests {

    @Test
    public void test1() {
        int input = 123;
        int expected = 321;
        ReverseInteger ri = new ReverseInteger();
        int reversed = ri.reverse(input);
        assertEquals(expected, reversed);
    }

    @Test
    public void test2() {
        int input = -123;
        int expected = -321;
        ReverseInteger ri = new ReverseInteger();
        int reversed = ri.reverse(input);
        assertEquals(expected, reversed);
    }

    @Test
    public void test3() {
        int input = 120;
        int expected = 21;
        ReverseInteger ri = new ReverseInteger();
        int reversed = ri.reverse(input);
        assertEquals(expected, reversed);
    }

    @Test
    public void test4() {
        int input = 1534236469;
        int expected = 0;
        ReverseInteger ri = new ReverseInteger();
        int reversed = ri.reverse(input);
        assertEquals(expected, reversed);
    }
}
