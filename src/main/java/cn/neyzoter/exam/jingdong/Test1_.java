package cn.neyzoter.exam.jingdong;

import java.util.Scanner;

/**
 * Test1
 * @author neyzoter
 */
public class Test1_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        for (int i = 1 ; i <= n; i++) {
            sum += fun2(i);
        }
        long sumD = (long) sum;
        long sumTemp = (long) ((sum - sumD) * 100000);
        long res = sumTemp % 10;
        sumTemp -= res;
        if (res >= 5) {
            sumTemp += 10;
        }

        System.out.println(String.format("%.4f", sumD + (double)sumTemp / 100000));
    }
    public static double fun1(int n) {
        return 1.0 / (5.0 * (2 * n - 1)) - 1.0 / (5.0 * 2 * n);
    }
    public static double fun2(int n) {
        return 1.0 / (20.0 * n * n - 10.0 * n);
    }
}
