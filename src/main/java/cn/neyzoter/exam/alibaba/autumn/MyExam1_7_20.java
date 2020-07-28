package cn.neyzoter.exam.alibaba.autumn;

import java.util.Scanner;

/**
 *
 * n 由三个互不相等的数相加而得，这三个数两两的最大公约数是k，1 <= k <= n <= 10^18。
 * 输入：T组数据，每行给定n和k。
 * 输出：是否存在这样三个数，存在则输出任意一组答案（n = x + y +z）,不存在则输出-1。
 */
public class MyExam1_7_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num -- != 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (n % k != 0) {
                System.out.println(-1);
            }
            int res = n / k;
            boolean notFind = true;
            for (int x = 1; x < res && notFind; x++) {
                int yRes = res - x;
                for (int y = x + 1; y < yRes && notFind; y++) {
                    int z = yRes - y;
                    if (z > 0) {
                        if (x == y || x == z || y == z) {
                            continue;
                        }
                        int gcd1 = gcd(x, y);
                        int gcd2 = gcd(y, z);
                        int gcd3 = gcd(x, z);
                        if (gcd1 == 1 && gcd2 == 1 && gcd3 == 1) {
                            System.out.println(String.format("%d %d %d", k * x, k * y, k * z));
                            notFind = false;
                        }
                    }
                }
            }
            if (notFind) {
                System.out.println(-1);
            }
        }
    }
    public static int gcd(int val1, int val2) {
        return val2 == 0 ? val1 : gcd(val2, val1 % val2);
    }
}
