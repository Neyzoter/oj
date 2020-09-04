package cn.neyzoter.exam.baidu;

import java.util.Scanner;

/**
 * Test2
 * AC 0%
 * 爬楼梯问题，最多m步，n级台阶而且连续三步的步数不同
 * @author neyzoter
 */
public class Test3 {
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int sum = climbStairs(n);
        System.out.println(sum);
    }
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;dp[2] = 2;
        for (int i = 3 ; i <= n ; i++) {
            for (int step = 1; step <= m; step++) {
                if (i - step >= 0) {
                    dp[i] += dp[i-step];
                }
            }
        }
        return dp[n];
    }
}
