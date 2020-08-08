package cn.neyzoter.exam.net;

import java.util.Scanner;

/**
 * 测试1
 * 网易
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long num = scanner.nextLong();
            if (num != 1) {
                if (num % 2 == 1) {
                    num -= 3;
                    sum++;
                }
                sum += num / 2;
            }
        }
        System.out.println(sum);
    }
}
