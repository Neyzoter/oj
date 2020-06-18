package cn.neyzoter.leetcode.algo.array;

/**
 * 198. 打家劫舍
 * @author Charles Song
 * @date 2020-6-18
 */
public class _198_Rob {
    public static void main (String[] args) {
        int[] nums = {1,2,3,1};
        Sol2_198_Rob rob = new Sol2_198_Rob();
        System.out.println(rob.rob(nums));
    }
}

class Sol1_198_Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i ++) {
            dp[i][0] = Math.max(getDp(dp, i - 1, 1), getDp(dp,i - 1, 0));
            dp[i][1] = getDp(dp, i - 1, 0) + nums[i];
        }
        int bigger = dp[nums.length - 1][0] > dp[nums.length - 1][1] ? dp[nums.length - 1][0] : dp[nums.length - 1][1];
        return bigger;
    }

    public static int getDp (int[][] dp, int i, int j) {
        if (i < 0) {
            return 0;
        } else {
            return dp[i][j];
        }
    }
}

class Sol2_198_Rob {
    public int rob(int[] nums) {
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 0; i < nums.length; i ++) {
            int dp0temp = dp0;
            dp0 = Math.max(dp1, dp0);
            dp1 = dp0temp + nums[i];
        }
        int bigger = dp0 > dp1 ? dp0 : dp1;
        return bigger;
    }

}