package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyAtoiTests {

    @Test
    public void test1() {
        String input = "42";
        int expected = 42;
        MyAtoi m = new MyAtoi();
        int res = m.atoi(input);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void test2() {
        String input = "-42";
        int expected = -42;
        MyAtoi m = new MyAtoi();
        int res = m.atoi(input);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void test3() {
        String input = "-91283472332";
        int expected = Integer.MIN_VALUE;
        MyAtoi m = new MyAtoi();
        int res = m.atoi(input);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void test4() {
        String input = "2147483648";
        int expected = Integer.MAX_VALUE;
        MyAtoi m = new MyAtoi();
        int res = m.atoi(input);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void test5() {
        String input = " ";
        int expected = 0;
        MyAtoi m = new MyAtoi();
        int res = m.atoi(input);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void test6() {
        String input = "+1";
        int expected = 1;
        MyAtoi m = new MyAtoi();
        int res = m.atoi(input);
        Assertions.assertEquals(expected, res);
    }
}
