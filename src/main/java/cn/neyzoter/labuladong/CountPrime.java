package cn.neyzoter.labuladong;

import java.util.Arrays;

/**
 * 高效寻找素数
 * @author neyzoter
 */
public class CountPrime {
    public static void main(String[] args) {
        int n = 10;
        boolean[] isPrime = prime(n);
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Sieve of Eratosthenes
     * @param n 最大数
     * @return 小于n的数字是否是素数
     */
    public static boolean[] prime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 这里优化为了i * i
                for (int j = i * i; j < n + 1; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
