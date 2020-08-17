package cn.neyzoter.exam.dji;

import java.util.Scanner;

/**
 * 70%
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        int rm = 0;
        for (; rm < k; ) {
            for (int idx = 0; idx < str.length(); idx++) {
                char ch = str.charAt(idx);
                if (idx < str.length() - 1) {
                    char nextChar = str.charAt(idx + 1);
                    if (ch > nextChar) {
                        str = str.substring(0, idx) + str.substring(idx + 1);
                        rm++;
                        break;
                    }
                }
            }
        }
        String result = str.substring(0, str.length() - k + rm);
        int zeroI = 0;
        for (; zeroI < result.length(); zeroI++) {
            char ch = result.charAt(zeroI);
            if (ch != '0') {
                break;
            }
        }
        result = result.substring(zeroI);
        System.out.print(result);
    }
}