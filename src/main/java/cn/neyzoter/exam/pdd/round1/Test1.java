package cn.neyzoter.exam.pdd.round1;

import java.util.Scanner;

/**
 * AC 100%
 * 飞行棋距离终点的长度和后退的次数
 * 中途到达则输出paradox
 * 输入实例
 * k：距离
 * n：骰子次数
 * <pre>
 *     6 3
 *     4 2 6
 * </pre>
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int[] di = new int[n];
        int backward = 0;
        for (int i = 0; i < n; i++) {
            di[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (k == 0) {
                System.out.println("paradox");
                return;
            }
            int step = di[i];
            k -= step;
            if (k < 0) {
                k = - k;
                backward ++;
            }
        }
        System.out.println(String.format("%d %d", k, backward));
    }

}

