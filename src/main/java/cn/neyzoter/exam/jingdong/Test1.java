package cn.neyzoter.exam.jingdong;

import java.util.Scanner;

/**
 * Test1
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double sum = 0;
            double num = n;
            for (int i = m; i > 0; i--) {
                sum += num;
                num = Math.sqrt(num);
            }
            long sumTemp = (long) (sum * 1000);
            long res = sumTemp % 10;
            sumTemp -= res;
            if (res >= 5) {
                sumTemp += 10;
            }
            System.out.println(String.format("%.3f", (double)sumTemp / 1000));
        }
    }
}
