package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinChangeTest {

    @Test
    public void test1() {
        int amount = 100;
        CoinChange c = new CoinChange();
        int ways = c.makeChange(amount);
        Assertions.assertEquals(6962, ways);
    }
}
