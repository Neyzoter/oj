package cn.neyzoter.leetcode.algo.array;

/**
 * 300. 最长上升子序列
 * @author neyzoter
 */
public class _300_LengthOfLIS {
    public static void main(String[] arg) {
        Sol1_300_LengthOfLIS sol = new Sol1_300_LengthOfLIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(sol.lengthOfLIS(nums));
    }
}

/**
 * 时间复杂度O(nlog(n))
 */
class Sol1_300_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        int res = 1;
        temp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = res;
            // 如果生序，则添加到后边
            if (nums[i] > temp[res - 1]) {
                temp[res] = nums[i];
                res++;
            // 如果降序，则将该数替换temp中比该数大的第一个数字
            } else if (nums[i] < temp[res - 1]) {
                int idx = firstBig(temp, left, right - 1, nums[i]);
                temp[idx] = nums[i];
            }
        }
        return res;
    }

    /**
     * 找到nums[s, e]范围内的比目标target大的第一个数字下标
     * @param nums 数组
     * @param s 数组开始下标
     * @param e 数组结束下标（包含）
     * @param target 目标
     * @return 比目标大的第一个数字下标
     */
    public int firstBig(int[] nums, int s, int e, int target) {
        int left = s, right = e;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) { // 小于
                left = mid + 1;
            } else { // 大于等于
                right = mid;
            }
        }
        return left;
    }
}
