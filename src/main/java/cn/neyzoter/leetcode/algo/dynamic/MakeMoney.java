package cn.neyzoter.leetcode.algo.dynamic;

import java.util.Arrays;

/**
 * 322.凑零钱
 * @author Charles Song
 * @date 2020-6-2
 */
public class MakeMoney {
    public static void main (String[] args) {
        int[] coins = {2};
        int min = Sol1_MakeMoney.dp(coins, 11);
        System.out.println("min = " + min);
    }
}

class Sol1_MakeMoney {
    public static int dp (int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int sum = 0; sum <= amount; sum ++) {
            for (int coin : coins) {
                if (sum - coin >= 0) {
                    if (dp[sum - coin] != -1) {
                        dp[sum] = min(dp[sum], 1 + dp[sum - coin]);
                    }

                }
            }
        }
        return dp[amount];
    }
    public static int min (int dpi, int n) {
        if (dpi < 0 || n < 0) {
            return dpi >= n ? dpi : n;
        } else {
            return Math.min(dpi, n);
        }
    }
}
