package cn.neyzoter.exam.pony;

import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++){
            for (int j = i + 1; j - i <= str.length() - j; j++) {
                int idx = i, jdx = j;
                boolean valid = true;
                while (idx < j) {
                    if (str.charAt(idx) != str.charAt(jdx)) {
                        valid = false;
                        break;
                    }
                    idx++;jdx++;
                }
                sum += valid ? 1 : 0;
            }
        }
        System.out.println(sum);
    }
}
