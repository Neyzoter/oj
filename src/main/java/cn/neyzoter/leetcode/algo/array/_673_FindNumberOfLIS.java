package cn.neyzoter.leetcode.algo.array;

/**
 * 673. 最长递增子序列的个数
 * @author Charles Song
 * @date 2020-6-11
 */
public class _673_FindNumberOfLIS {
    public static void main (String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2};
        Sol1_FindNumberOfLIS sol = new Sol1_FindNumberOfLIS();
        System.out.println(sol.findNumberOfLIS(nums));
    }
}

class Sol1_FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        DP[] dp = new DP[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            dp[i] = new DP(1);
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    if (dp[j].len == dp[i].len - 1) {
                        dp[i].num += dp[j].num;
                    } else if (dp[j].len > dp[i].len - 1) {
                        dp[i].len = dp[j].len + 1;
                        dp[i].num = dp[j].num;
                    }
                }
            }
        }
        int len = 0;
        int num = 0;
        for (DP d : dp) {
            if (d.len > len) {
                num = d.num;
                len = d.len;
            } else if (d.len == len) {
                num += d.num;
            }
        }
        return num;
    }

    class DP {
        // 最长长度
        public int len;
        // 最长长度的个数
        public int num;
        public DP (int l) {
            this.len = l;
            this.num = 1;
        }
    }
}