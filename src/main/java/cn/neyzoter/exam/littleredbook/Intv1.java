package cn.neyzoter.exam.littleredbook;

import java.util.Arrays;

/**
 * @author neyzoter
 */
public class Intv1 {
    public static void main(String[] args) {
        System.out.println(f(new int[][] {{1,2}, {0, 0}, {0, 3}}));
        System.out.println(f(new int[][] {{}}));
        System.out.println(f(new int[][] {{0, 2}, {1, 3}, {2, 4}}));
        System.out.println(f(new int[][] {{0, 3}, {1, 2}}));
    }


    // [[1,3],[2,4]]
    // 输入是一个二维数组，第二维数组代表一维空间上的一个线段，并且第二数组长度一定是2
    // 求线段覆盖的区间长度，重复覆盖的区间不要重复计算长度
    // 3
    static int f(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        Arrays.sort(m, (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] range0 = m[0];
        int res = 0;
        for (int i = 1; i < m.length; i++) {
            int[] range1 = m[i];
            if (range0[1] > range1[0]) {
                range0[1] = Math.max(range1[1], range0[1]);
            } else {
                res += range0[1] - range0[0];
                range0 = range1;
            }
        }
        res += range0[1] - range0[0];
        return res;
    }
}
