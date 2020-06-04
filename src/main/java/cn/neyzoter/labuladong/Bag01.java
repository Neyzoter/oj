package cn.neyzoter.labuladong;

/**
 * 01背包问题
 * @author Charles Song
 * @date 2020-6-4
 */
public class Bag01 {
    public static void main (String[] args) {
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        int w = 4;
        System.out.println(dp(w, wt, val));
    }

    /**
     *
     * @param w 背包容量
     * @param wt 货物重量
     * @param val 货物价值
     * @return 最大价值
     */
    public static int dp (int w, int[] wt, int[] val) {
        int[][] dp = new int[wt.length + 1][w + 1];
        // 初始状态为i = 0, j = 0, 数值为0
        // 货物
        for (int i = 1 ; i < wt.length + 1; i ++) {
            // 背包容量不断增加
            for (int j = 1; j <= w; j ++) {
                if (wt[i - 1] > j) {
                    // 不能放，只能取决于前一次情况
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 放或者不放，两种情况
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[wt.length - 1][w];
    }
}