package cn.neyzoter.sword;

import java.util.*;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @author neyzoter
 */
public class _56II_OnlyOneNumsPlus {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        System.out.println(System.getProperty("spring.profiles.active"));
        System.out.println(System.getenv("spring.profiles.active"));
    }
}

class Sol_56II_OnlyOneNumsPlus {
    public int singleNumber(int[] nums) {
        int[] state = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                int bit = n & 0x1;
                if (bit == 1) {
                    state[i] += 1;
                }
                n >>= 1;
            }
        }
        int bin = 1;
        int val = 0;
        for (int n : state) {
            n %= 3;
            val += n * bin;
            bin *= 2;
        }
        return val;
    }
}