package cn.neyzoter.exam.jingdong;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Test2
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int num = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = min; i <= max; i++) {
            String strNum = String.valueOf(i);
            for (int j = 0; j < strNum.length(); j++) {
                String subStrNum = subString(strNum, j);
                if (set.contains(subStrNum)) {
                    num ++;
                    break;
                } else if (hW(subStrNum) && isPrime(Integer.parseInt(subStrNum))) {
                    set.add(subStrNum);
                    num++;
                    break;
                }
            }

        }
        System.out.println(num);
    }
    public static boolean hW(String str) {
        for (int i = 0 , j = str.length() - 1; i < j; i++, j--) {
            if ( str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public static boolean canHw(String num, int l, int r, boolean skiped) {
        if (l >= r) {
            return skiped;
        }
        if (num.charAt(l) != num.charAt(r)) {
            if (!skiped) {
                return canHw(num, l + 1, r, true) ||
                        canHw(num, l, r - 1, true);
            }
            return false;
        }
        return canHw(num, l + 1, r - 1, skiped);
    }
    public static boolean isPrime(int num) {
        if (num == 1 || num == -1) {
            return true;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static String subString(String str, int idx) {
        return str.substring(0, idx) + str.substring(idx + 1);
    }
}
