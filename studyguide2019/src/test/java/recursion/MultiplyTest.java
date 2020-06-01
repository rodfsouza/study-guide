package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplyTest {

    @Test
    public void test1() {
        int a = 3;
        int b = 4;
        Multiply m = new Multiply();
        int result = m.minProduct(a, b);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void test2() {
        int a = 4;
        int b = 4;
        Multiply m = new Multiply();
        int result = m.minProduct(a, b);
        Assertions.assertEquals(16, result);
    }

    @Test
    public void test3() {
        int a = -3;
        int b = 4;
        Multiply m = new Multiply();
        int result = m.minProduct(a, b);
        Assertions.assertEquals(-12, result);
    }
}
