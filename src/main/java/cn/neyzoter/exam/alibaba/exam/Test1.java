package cn.neyzoter.exam.alibaba.exam;

/**
 * 阿里巴巴测试
 * @author neyzoter
 */
import java.util.Scanner;
public class Test1 {
    public static int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(pow(3,2));
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            long num = pow(m + 1, n, mod);
            System.out.println(String.format("(%d + 1)^%d = %d", m, n, num));
            System.out.println(num);
        }
    }
    public static long pow(int m, int n, int mod) {
        m %= mod;
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * m % mod;
            }
            m = m * m % mod;
            n = n >>> 1;
        }
        return res % mod;
    }

    public static long pow(int m, int n) {
        if (n == 0) {
            return 1;
        }
        long p = pow(m, n / 2);
        long res = p * p % mod;
        if (n % 2 == 1) {
            res = res * m % mod;
        }
        return res;
    }
}