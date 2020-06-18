package cn.neyzoter.leetcode.algo.array;

/**
 * 213. 打家劫舍 II
 * @author Charles Song
 * @date @020-6-18
 */
public class _213_Rob {
    public static void main (String[] args) {
        int[] nums = {1,2,3,1};
        Sol1_213_Rob sol = new Sol1_213_Rob();
        System.out.println(sol.rob(nums));
    }
}
class Sol1_213_Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int startWithZero = rob(nums, 1, nums.length - 1);
        int startWithOne = rob(nums, 2, nums.length - 2) + nums[0];
        return Math.max(startWithOne, startWithZero);

    }

    public static int rob(int[] nums, int stt, int end) {
        int dp0 = 0;
        int dp1 = 0;
        int dp0temp;
        for (int i = stt; i < end + 1; i ++) {
            dp0temp = dp0;
            dp0 = Math.max(dp1, dp0);
            dp1 = dp0temp + nums[i];
        }
        return dp0 > dp1 ? dp0 : dp1;
    }
}