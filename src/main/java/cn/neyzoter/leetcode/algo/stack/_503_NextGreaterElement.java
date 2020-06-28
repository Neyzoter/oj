package cn.neyzoter.leetcode.algo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * @author Charles Song
 * @date 2020-6-26
 */
public class _503_NextGreaterElement {
    public static void main (String[] args) {

    }
}

class Sol1_503_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length * 2];
        for (int i = nums.length * 2 - 1; i >= 0; i --) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.add(nums[i % nums.length]);
        }
        int[] r = Arrays.copyOf(result, nums.length);
        return r;
    }
}
