package cn.neyzoter.leetcode.algo.array;

/**
 * 714. 买卖股票的最佳时机含手续费
 * @author Charles Song
 * @date 2020-6-17
 */
public class _714_MaxProfit {
    public static void main (String[] args) {
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        Sol4_MaxProfit sol = new Sol4_MaxProfit();
        System.out.println(sol.maxProfit(prices1, 2));
    }
}

class Sol4_MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length + 1; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][0] - fee - prices[i - 1], dp[i - 1][1]);
        }
        return dp[prices.length][0];
    }
}
