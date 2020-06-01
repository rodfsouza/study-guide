package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickMathTest {

    @Test
    public void test1() {
        QuickMath q = new QuickMath();
        int result = q.func(2);
        Assertions.assertEquals(8, result);
    }
}
