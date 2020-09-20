package cn.neyzoter.exam.meituan;

import java.util.Scanner;

/**
 * @author neyzoter
 */
public class FindFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String S;
        String T;
        do {
            S = sc.nextLine();
        } while (S.length() != n);
        do {
            T = sc.nextLine();
        } while (T.length() != m);
        long res = find(S, T);
        if (res == -1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            System.out.println(res);
        }
    }
    public static long find(String s, String t) {
        int ti = 0, si = 0;
        long res = 0;
        for (; si < s.length(); si++) {
            char chs = s.charAt(si);
            char cht = t.charAt(ti);
            if (chs == cht) {
                ti++;
                res += si + 1;
            }
            if (ti == t.length()) {
                return res;
            }
        }
        return -1;
    }
}
