package dp;

/**
 * They found out you're a programmer and asked you to solve something they've been wondering for a long time.
 *
 * Write a method that, given:
 *
 * an amount of money
 * an array of coin denominations
 * computes the number of ways to make the amount of money with coins of the available denominations.
 *
 * Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢), your program would output 44—the number of ways to make 44¢ with those denominations:
 *
 * 1¢, 1¢, 1¢, 1¢
 * 1¢, 1¢, 2¢
 * 1¢, 3¢
 * 2¢, 2¢
 */

public class CoinProblem {

    public static int changePossibilitiesBottomUp(int amount, int[] den) {
        int[] ways = new int[amount + 1];
        ways[0] = 1;

        for (int coin : den) {
            for (int higher = coin; higher <= amount; higher++) {
                int remainder = higher - coin;
                ways[higher] += ways[remainder];
            }
        }
        return ways[amount];
    }
}
