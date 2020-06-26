package cn.neyzoter.leetcode.algo.stack;


import java.util.*;

/**
 * 496. 下一个更大元素 I
 * @author Charles Song
 * @date 2020-6-26
 */
public class _496_NextGreaterElement {
    public static void main (String[] args) {

    }
}

/**
 * 暴力法
 */
class Sol1_496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int j = 0; j < nums1.length; j ++) {
            int n1 = nums1[j];
            int i = 0;
            while (nums2[i] != n1) {
                i ++;
            }
            result[j] = exitBigger(nums2, i + 1, n1);
        }
        return result;
    }
    public static int exitBigger (int[] nums, int start, int target) {
        for (int i = start; i < nums.length; i ++) {
            if (nums[i] > target) {
                return nums[i];
            }
        }
        return -1;
    }
}

/**
 * 单调栈
 */
class Sol2_496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i = nums2.length - 1; i >= 0; i --) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.add(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

}