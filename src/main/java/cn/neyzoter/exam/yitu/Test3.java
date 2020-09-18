package cn.neyzoter.exam.yitu;

import java.util.Scanner;

/**
 * AC 45%
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        if (k2 > k1) {
            System.out.println(String.format("%s\n%d %d %d", "YES", x, y, z));
            return;
        }
        int money = (x * 17 + y) * 29 + z;
        int[] dp = new int[money + 1];
        int[] price = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), p = sc.nextInt();
            price[i] = (a * 17 + b) * 29 + c;
            value[i] = p;
        }
        for (int i = 0; i < n; i++) {
            for (int j = money; j >= price[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - price[i]] + value[i]);
            }
        }
        for (int i = 0; i <= money; i++) {
            if (dp[i] + k2 > k1) {
                money -= i;
                int a = money / 29 / 17;
                int b = (money - a * 17 * 29) / 29;
                int c = money - a * 17 * 29 - b * 29;
                System.out.println(String.format("%s\n%d %d %d", "YES", a, b, c));
                return;
            }
        }
        System.out.println("NO");
    }
}
