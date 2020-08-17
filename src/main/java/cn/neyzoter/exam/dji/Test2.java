package cn.neyzoter.exam.dji;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * AC 100%
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[][] info = new int[n][2];
        for (int i = 0; i < n; i++) {
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
        }
        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        long ms = milestone(x, 0, info, 0);
        System.out.print(ms);
    }
    public static long milestone(int x, int s, int[][] info, int ms) {
        // 时间不够了
        if (s >= info.length || x < info[s][1]) {
            return ms;
        }
        long num1 = milestone(x, s + 1, info, ms);
        long num2 = info[s][0] + milestone(x - info[s][1], s + 1, info, ms);
        return ms + Math.max(num1, num2);
    }
}