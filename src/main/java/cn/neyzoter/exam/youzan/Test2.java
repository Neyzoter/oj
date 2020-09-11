package cn.neyzoter.exam.youzan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * AC 100%
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Set<Short> set = new HashSet<>();
        Short a = 123;
        Short b = 124;
        set.add(a);
        // 由于是b - 1后变成了Integer，所以不会删除元素(Short) 123
        set.remove(b - 1);
        System.out.print(set.size());
    }
}

class Sol_Youzan2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 最少移动次数
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minMoves (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int midValue = nums[mid];
        int res = 0;
        for (int n : nums) {
            res += Math.abs(n - midValue);
        }
        return res;
    }
}