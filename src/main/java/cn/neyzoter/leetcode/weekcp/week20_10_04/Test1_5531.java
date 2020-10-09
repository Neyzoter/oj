package cn.neyzoter.leetcode.weekcp.week20_10_04;

import java.util.Arrays;

/**
 * 2020年10月04日周赛
 *
 * @author neyzoter
 */
public class Test1_5531 {
    public static void main(String[] args) {
        Sol sol = new Sol();
        int[] nums = {3,6,7,7,0};
//        Arrays.sort(nums);
//        System.out.println(sol.findSmaller(nums, 0));
        System.out.println(sol.specialArray(nums));
    }
}

class Sol {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums[nums.length - 1]; i++) {
            int smidx = findSmaller(nums, i);
            if (i == nums.length - smidx) {
                return i;
            }
        }
        return -1;
    }

    public int findSmaller(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
