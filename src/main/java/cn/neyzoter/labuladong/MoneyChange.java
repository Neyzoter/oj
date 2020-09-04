package cn.neyzoter.labuladong;

/**
 * 零钱兑换<br>
 * 零钱可以无限使用<br>
 * leetcode
 * @author neyzoter
 */
public class MoneyChange {

    /**
     * 使用二维矩阵实现
     * @param amount 目标数
     * @param coins 零钱
     * @return 组成amount的个数
     */
    int change1(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1]; // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i-1] >= 0) dp[i][j] = dp[i - 1][j]
                        + dp[i][j - coins[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[n][amount];
    }
    /**
     * 使用二维矩阵实现
     * @param amount 目标数
     * @param coins 零钱
     * @return 组成amount的个数
     */
    int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case
        for (int i = 0; i < n; i++)
            for (int j = 1; j <= amount; j++)
                if (j - coins[i] >= 0)
                    dp[j] = dp[j] + dp[j-coins[i]];
        return dp[amount];
    }
}
