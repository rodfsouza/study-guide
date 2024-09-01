package dp;

public class ClimbingStairs {

    public int climb(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int step = 2; step <= n; ++step) {
            dp[step] = dp[step - 1] + dp[step - 2];
        }

        return dp[n];
    }
}
