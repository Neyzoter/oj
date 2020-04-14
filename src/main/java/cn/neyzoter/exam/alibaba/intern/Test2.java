package cn.neyzoter.exam.alibaba.intern;

import java.util.Scanner;

/**
 * Alibaba Exam2<br/>
 * 注意类名必须为Main, 不要有任何package xxx信息
 * @author Charles Song
 * @date 2020-3
 */
public class Test2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();int m = sc.nextInt();int x = sc.nextInt();
            int[][] path = new int[m][3];
            for (int i = 0 ; i < m ; i++) {
                path[i][0] = sc.nextInt();
                path[i][1] = sc.nextInt();
                path[i][2] = sc.nextInt();
            }
        }
    }
    public static void maxLen (int n, int m, int x, int[][] path) {
        int maxLen = 0;
    }
}


