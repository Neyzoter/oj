package cn.neyzoter.exam.pdd.round1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 食堂吃饭, 分中餐和晚餐, 每一餐又分若干种套餐. 每种套餐有热量和美味值两个属性.
 * 每餐最多只能选一种套餐(可不吃). 问在满足能量值的情况下, 最少摄入的热量.
 * 返回最少的热量, 如果不能达到美味值则返回-1. 50%的中餐晚餐不超过100000种, 100%的中餐晚餐不超过200000种.
 *
 * 3 3 10 // 中餐套餐数 晚餐套餐数 要求的美味值
 * 1 1 // 热量 美味值
 * 2 5
 * 3 7
 * 2 4
 * 4 8
 * 6 9
 *
 * 将返回 5 (中餐选3 7 晚餐选 2 4, 此时热量最少)
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int t = in.nextInt();
        int[][] lunch = new int[n][2];
        int[][] dinner = new int[m][2];
        for (int i = 0;i < n; i++) {
            lunch[i][0] = in.nextInt();
            lunch[i][1] = in.nextInt();
        }
        // 根据美味值排序
        Arrays.sort(lunch, Comparator.comparingInt(o -> o[1]));
        for (int i = 0;i < m; i++) {
            dinner[i][0] = in.nextInt();
            dinner[i][1] = in.nextInt();
        }
        // 根据美味值排序
        Arrays.sort(dinner, Comparator.comparingInt(o -> o[1]));
        if (t == 0) {
            System.out.println(0);
            return;
        }
        int result = -1;
        for (int i = -1; i < n; i++) {
            int power = 0;
            int dilecious = 0;
            // 吃
            if (i != -1) {
                // 跳过
                // 因为相对于后边的来说没有意义
                // 能量高，美味值低
                if (skip(lunch, i)) {
                    continue;
                }
                power = lunch[i][0];
                dilecious = lunch[i][1];
            }
            for (int j = -1; j < m; j++) {
                if (j != -1) {
                    if (dilecious + dinner[j][1] >= t) {
                        result = setResult(result, dinner[j][0] + power);
                    }
                } else {
                    if (dilecious >= t) {
                        result = setResult(result, power);
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static int setResult(int r, int s) {
        if (r == -1) {
            return s;
        }
        return Math.min(r, s);
    }

    public static boolean skip(int[][] food, int n) {
        if (n < food.length - 1) {
            // food已经按照美味数值排序，如果food[n]的能量还要高于n+1
            // 则可以直接跳过
            return food[n][0] >= food[n + 1][0];
        }
        return false;
    }
}
