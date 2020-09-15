package cn.neyzoter.exam.xiaomi;

import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean[] used = new boolean[128];
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (!used[ch]) {
                used[ch] = true;
                System.out.print(ch);
            }
        }
    }
}
