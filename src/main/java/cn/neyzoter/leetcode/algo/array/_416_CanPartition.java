package cn.neyzoter.leetcode.algo.array;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 416. 分割等和子集
 * @author Charles Song
 * @date 2020-6-4
 */
public class _416_CanPartition {
    public static void main (String[] args) {
        int[] nums = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 5};
        Sol1_CanPartition sol = new Sol1_CanPartition();
        System.out.println(sol.canPartition(nums2));
    }
}

class Sol1_CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int sum = sum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][half + 1];
        // half = 0，则一定可以找到
        for (int i = 0; i < nums.length + 1; i ++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length + 1; i ++) {
            for (int j = 1; j < half + 1; j ++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][half];

    }
    public static int sum (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

/**
 * sol1的状态压缩版本
 */
class Sol2_CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int sum = sum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length + 1; i ++) {
            // 注意j从half开始，防止一个数字被使用多次
            for (int j = half; j > 0; j --) {
                if (dp[j]) {
                    break;
                }
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[half];
    }
    public static int sum (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
