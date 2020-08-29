package cn.neyzoter.exam.meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 美团测试
 * <pre>
 * 5 5
 * 4 1 4 1 2
 * </pre>
 * @author neyzoter
 */
public class Meituan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean[][] dp = new boolean[m + 1][m + 1];
        int sum = 0;
        for (int min = 1; min <= m; min++) {
            for (int l = 1, r = min; l <= m && r <= m; l++, r++) {
                if (((r - 1) >= 0 && dp[l][r - 1]) || ((l + 1 <= m) && dp[l + 1][r])) {
                    dp[l][r] = true;
                } else {
                    dp[l][r] = checkNums(nums, m, l, r);
                }
                sum = dp[l][r] ? sum + 1 : sum;
            }
        }
        System.out.println(sum);
    }

    /**
     * 检查是否满足两个条件
     * @param nums 完整的序列
     * @param m 最大数值
     * @param l l
     * @param r r
     * @return 是否满足
     */
    public static boolean checkNums(int[] nums, int m, int l, int r) {
        int tmp = Integer.MIN_VALUE;
        for (int n : nums) {
            if (checkN(n, m, l, r)) {
                if (n < tmp) {
                    return false;
                }
                tmp = n;
            }
        }
        return true;
    }

    /**
     * 检查数字是否满足1、2条件
     * @param n 数字
     * @param m 最大数值
     * @param l l
     * @param r r
     * @return 是否满足1、2条件
     */
    public static boolean checkN(int n, int m, int l, int r) {
        return l <= r && ((n > 0 && n < l) || (r < n) && (n <= m));
    }
}
