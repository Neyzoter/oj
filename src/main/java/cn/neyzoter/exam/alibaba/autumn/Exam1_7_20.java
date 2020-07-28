package cn.neyzoter.exam.alibaba.autumn;


import java.util.*;
/**
 *
 * n 由三个互不相等的数相加而得，这三个数两两的最大公约数是k，1 <= k <= n <= 10^18。
 * 输入：T组数据，每行给定n和k。
 * 输出：是否存在这样三个数，存在则输出任意一组答案（n = x + y +z）,不存在则输出-1。
 */
public class Exam1_7_20 {

    static long gcd(long a, long b) {
        return b == 0 ?  a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            boolean flag = false;
            if ( n % k != 0) {
                System.out.println(-1);
                continue;
            }
            long p = n / k;

            for (long x = 1; x <= p - 3 && !flag; x++) {
                for (long y = x + 1; y < p - x && !flag; y++) {
                    long z =  (p - x - y);
                    if (z != x && z != y) {
                        long temp1 = gcd(z, x);
                        if (temp1 != 1 ) continue;
                        long temp2 = gcd(z, y);
                        if (temp2 != 1 ) continue;
                        long temp3 = gcd(x, y);
                        if (temp3 != 1 ) continue;
                        System.out.println(x* k+ " " + y * k + " " + z * k);
                        flag = true;
                    }
                }
            }
            if (!flag) System.out.println(-1);
        }
        scanner.close();
    }
}