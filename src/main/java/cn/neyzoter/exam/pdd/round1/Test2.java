package cn.neyzoter.exam.pdd.round1;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 通过25%样例
 * 以下代码已经经过修改
 * 判断N个骰子是否相同
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] touzi = new int[n][6];
        boolean[] removed = new boolean[n];
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                touzi[i][j] = in.nextInt();
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (removed[i]) {
                continue;
            }
            type[idx] ++;
            removed[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (!removed[j]) {
                    if (same(touzi[i], touzi[j])) {
                        removed[j] = true;
                        type[idx] ++;
                    }
                }
            }
            idx++;
        }
        System.out.println(idx);
        Arrays.sort(type);
        for (int i = n - 1; i >= n - idx; i--) {
            System.out.print(type[i]);
            if (i != n - idx) {
                System.out.print(" ");
            }
        }
    }


    public static boolean same(int[] t1, int t21, int t22, int t23, int t24, int t25, int t26){
        return (t1[0] == t21) && (t1[1] == t22) && (t1[2] == t23)
                && (t1[3] == t24) && (t1[4] == t25) && (t1[5] == t26);
    }

    public static boolean midSame(int[] t1, int t21, int t22, int t23, int t24, int t25, int t26) {
        return same(t1, t21, t22, t23, t24, t25, t26) ||
                same(t1, t21, t22, t26, t25, t23, t24) ||
                same(t1, t21, t22, t24, t23, t26, t25) ||
                same(t1, t21, t22, t25, t26, t24, t23);
    }

    public static boolean same(int[] t1, int[] t2) {
        return midSame(t1, t2[0], t2[1], t2[2], t2[3], t2[4], t2[5]) ||
                midSame(t1, t2[1], t2[0], t2[2], t2[3], t2[5], t2[4]) ||
                midSame(t1, t2[2], t2[3], t2[5], t2[4], t2[1], t2[0]) ||
                midSame(t1, t2[3], t2[2], t2[4], t2[5], t2[1], t2[0]) ||
                midSame(t1, t2[4], t2[5], t2[2], t2[3], t2[1], t2[0]) ||
                midSame(t1, t2[5], t2[4], t2[3], t2[2], t2[1], t2[0]);
    }
}
