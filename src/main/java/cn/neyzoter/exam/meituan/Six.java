package cn.neyzoter.exam.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 100000 110000
 * 0
 * @author neyzoter
 */
public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(find(n, m));
    }
    public static int find(int n, int m) {
        int sum = 0;
        for (int i = n; i <= m; i++) {
            int res = i;
            Set<Integer> set = new HashSet<>();
            int A = res / 100000;res %= 100000;
            // 检查是否存在
            set.add(A);
            int B = res / 10000;res %= 10000;
            if (set.contains(B)) {
                continue;
            }
            set.add(B);
            int C = res / 1000;res %= 1000;
            if (set.contains(C)) {
                continue;
            }
            set.add(C);
            int D = res / 100;res %= 100;
            if (set.contains(D)) {
                continue;
            }
            set.add(D);
            int E = res / 10;res %= 10;
            if (set.contains(E)) {
                continue;
            }
            set.add(E);
            int F = res;
            if (set.contains(F)) {
                continue;
            }
            if (check(A, B, C, D, E, F)) {
                sum++;
            }
        }
        return sum;
    }
    public static boolean check(int A, int B, int C, int D, int E, int F) {
        if (A == 0 || C == 0 || E == 0) {
            return false;
        }
        return A * 10 + B + C * 10 + D == E * 10 + F;
    }
}
