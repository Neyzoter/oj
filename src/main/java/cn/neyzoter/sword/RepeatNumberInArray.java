package cn.neyzoter.sword;

import java.util.HashSet;

/**
 * 面试题03. 数组中重复的数字
 */
public class RepeatNumberInArray {
    public static void main (String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        Solution1_RepeatNumberInArray solution1_repeatNumberInArray = new Solution1_RepeatNumberInArray();
        System.out.println(solution1_repeatNumberInArray.findRepeatNumber(nums));

        Solution2_RepeatNumberInArray solution2_repeatNumberInArray = new Solution2_RepeatNumberInArray();
        System.out.println(solution2_repeatNumberInArray.findRepeatNumber(nums));
    }

}

/**
 * set
 */
class Solution1_RepeatNumberInArray {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}

class Solution2_RepeatNumberInArray {
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (temp[num] > 0) {
                return num;
            } else {
                temp[num] ++;
            }
        }
        return -1;
    }
}
