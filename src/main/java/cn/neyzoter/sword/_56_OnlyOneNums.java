package cn.neyzoter.sword;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 数组中有2个单个的数字，其他都是一对儿
 * @author neyzoter
 */
public class _56_OnlyOneNums {
}

class Sol_56_OnlyOneNums {
    public int[] singleNumbers(int[] nums) {
        int orx = nums[0];
        for (int i = 1; i < nums.length; i++) {
            orx ^= nums[i];
        }
        int oneBit = 0;
        while (true) {
            int bit = orx & 0x1;
            if (bit == 1) {
                break;
            }
            oneBit++;
            orx = orx >> 1;
        }
        int orx1 = 0, orx2 = 0;
        for (int n : nums) {
            int temp = n;
            n = n >> oneBit;
            if ((n & 0x1) == 1) {
                orx1 ^= temp;
            } else {
                orx2 ^= temp;
            }
        }
        return new int[]{orx1, orx2};
    }
}