package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinChangeTest {

    @Test
    public void testCoinChange() {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        int result = coinChange.change(coins, 11);
        assertEquals(3, result);
    }
}
