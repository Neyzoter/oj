package cn.neyzoter.exam.pdd.round2;

import java.util.Scanner;

/**
 * pdd测试4
 * AC 50%
 * @author neyzoter
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] div = new int[m];
        while (m-- > 0) {
            div[m] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int d : div) {
                if (i % d == 0) {
                    sum ++;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
