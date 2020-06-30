package cn.neyzoter.leetcode.algo.dynamic;

/**
 * 55. 跳跃游戏
 * @author Charles Song
 * @date 2020-6-30
 */
public class _55_CanJump {
    public static void main (String[] args) {
        int[] nums = {2,3,1,1,4};
        Sol1_55_CanJump sol = new Sol1_55_CanJump();
        System.out.println(sol.canJump(nums));
    }

}

class Sol1_55_CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        boolean [] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && i - j <= nums[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
