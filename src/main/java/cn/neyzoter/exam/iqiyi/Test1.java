package cn.neyzoter.exam.iqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Character> contain = new HashSet<>();
        int left = 0, right = 0;
        int len = 0;
        for (; right < str.length(); right++) {
            char ch = str.charAt(right);
            while (contain.contains(ch)) {
                char leftChar = str.charAt(left);
                contain.remove(leftChar);
                left++;
            }
            contain.add(ch);
            len = Math.max(len, contain.size());
        }
        System.out.print(len);
    }
}
