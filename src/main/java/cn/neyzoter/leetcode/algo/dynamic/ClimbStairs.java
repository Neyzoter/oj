package cn.neyzoter.leetcode.algo.dynamic;

/**
 * 70.爬楼梯
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int[] ns = {1,2,3,4,5,6,7,8,9,10};
        Solution1_ClimbStairs solution1_climbStairs = new Solution1_ClimbStairs();
        for (int n : ns) {
            System.out.println(String.format("n = %d , num = %d", n,solution1_climbStairs.climbStairs(n)));
        }
    }
}

/**
 * 动态规划
 */
class Solution1_ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;dp[2] = 2;
        for (int i = 3 ; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
