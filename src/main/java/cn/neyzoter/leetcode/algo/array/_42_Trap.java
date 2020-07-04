package cn.neyzoter.leetcode.algo.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 42. 接雨水
 * @author Charles Song
 * @date 2020-7-4
 */
public class _42_Trap {
    public static void main (String[] args) {
        int[] input = {0,1,0};
        System.out.println(Sol1_42_Trap.findPeek(input));
        Sol2_42_Trap sol = new Sol2_42_Trap();
        System.out.println(sol.trap(input));
    }
}

/**
 * 思路错误，会出现两个高山峰夹着小山峰的情况
 */
class Sol1_42_Trap {
    public int trap(int[] height) {
        List<Integer> peek = findPeek(height);
        if (peek.size() <= 1) {
            return 0;
        }
        Iterator<Integer> iter = peek.iterator();
        int li = iter.next();
        int ri;
        int result = 0;
        for (;iter.hasNext();) {
            ri = iter.next();
            int lv = height[li];
            int rv = height[ri];
            int min = Math.min(lv, rv);
            for (int i = li + 1; i < ri; i ++) {
                int delta = min - height[i];
                if (delta > 0) {
                    result += delta;
                }
            }
            li = ri;
        }
        return result;
    }

    public static List<Integer> findPeek(int[] height) {
        List<Integer> peek = new ArrayList<>();
        for (int i = 0; i < height.length; i ++) {
            if (isPeek(height, i)) {
                peek.add(i);
            }
        }
        return peek;
    }

    public static boolean isPeek(int[] height, int i) {
        int left = i - 1;
        int right = i + 1;
        if (i == 0 && right < height.length && height[i] > height[right]) {
            return true;
        } else if (i == height.length - 1 && left >= 0 && height[i] > height[left]) {
            return true;
        } else if (left >= 0 && right <= height.length - 1 && height[left] <= height[i] && height[right] <= height[i]) {
            return true;
        }
        return false;
    }
}

class Sol2_42_Trap {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int init = findNextPeek(height, -1, -1);
        int rml = init;
        int rmr = init;
        int sum = 0;
        for (;rml != 0 || rmr != height.length - 1;) {
            int nextIdx = findNextPeek(height, rml, rmr);
            if (nextIdx > rmr) {
                sum += cmpSum(height, rmr, nextIdx);
                rmr = nextIdx;
            } else {
                sum += cmpSum(height, nextIdx, rml);
                rml = nextIdx;
            }
        }
        return sum;
    }

    public static int findNextPeek(int[] height, int rml, int rmr) {
        int maxVal = -1;
        int maxIdx = -1;
        for (int i = 0 ; i < rml; i ++) {
            if (height[i] > maxVal) {
                maxVal = height[i];
                maxIdx = i;
            }
        }

        for (int i = rmr + 1 ; i < height.length; i ++) {
            if (height[i] > maxVal) {
                maxVal = height[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static int cmpSum(int[] height, int left, int right) {
        int minVal = Math.min(height[left], height[right]);
        int sum = 0;
        for (int i = left + 1; i < right; i ++) {
            int delta = minVal - height[i];
            sum += delta;
        }
        return sum;
    }
}