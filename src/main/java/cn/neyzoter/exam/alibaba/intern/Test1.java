package cn.neyzoter.exam.alibaba.intern;

import java.util.Scanner;

/**
 * Alibaba Exam1<br/>
 * 注意类名必须为Main, 不要有任何package xxx信息
 * @author Charles Song
 * @date 2020-3
 */
public class Test1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int[] A = new int[num];
            for (int i = 0 ; i < num ; i++) {
                A[i] = sc.nextInt();
            }
            count(num, A);
        }
    }
    public static void count (int num, int[] A) {
        int[] sum = new int[num];
        for (int i = 0; i < num ; i ++) {
            int idx = A[i] - 1;
            if (idx >= 0) {
                if (idx != i) {
                    int admIdx = A[idx] - 1;
                    if (admIdx >= 0) {
                        sum[admIdx] ++;
                    }
                    sum[idx] ++;
                }
            }
            sum[i] ++;
        }
        for (int i = 0 ; i < num ; i ++) {
            System.out.println(sum[i]);
        }
    }
}
