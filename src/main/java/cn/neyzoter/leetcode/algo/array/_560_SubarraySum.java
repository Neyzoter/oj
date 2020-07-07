package cn.neyzoter.leetcode.algo.array;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * @author Charles Song
 * @date 2020-7-7
 */
public class _560_SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        Sol1_560_SubarraySum sol = new Sol1_560_SubarraySum();
        System.out.println(sol.subarraySum(nums, 2));
    }
}

class Sol1_560_SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int num = 0;
        if (nums.length == 0) {
            return num;
        }
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length + 1; i ++) {
            for (int j = i + 1; j < nums.length + 1; j ++) {
                if (preSum[j] - preSum[i] == k) {
                    num ++;
                }
            }
        }
        return num;
    }
}

class Sol2_560_SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int num = 0;
        if (nums.length == 0) {
            return num;
        }
        HashMap<Integer, Integer> preSum = new HashMap<>(nums.length + 1);
        preSum.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            num += preSum.getOrDefault(sum - k, 0);
            // 有可能nums[i] = 0
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return num;
    }
}
