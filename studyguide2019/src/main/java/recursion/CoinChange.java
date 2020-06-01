package recursion;

public class CoinChange {

    private int[] COINS = {1, 5, 10, 25};

    public int makeChange(int amount) {
        if (amount < 0) {
            return 0;
        }
        return helper(amount, COINS, 0, new int[COINS.length][amount + 1]);
    }

    private int helper(int amount, int[] coins, int index, int[][] cache) {

        if (index > coins.length - 1) {
            return 1;
        }

        if (cache[index][amount] > 0) {
            return cache[index][amount];
        }

        int denAmount = coins[index];
        int ways = 0;

        for (int i = 0; i * denAmount <= amount; ++i) {
            int rem = amount - i * denAmount;
            ways += helper(rem, coins, index + 1, cache);
        }
        cache[index][amount] = ways;
        return ways;
    }
}
