package cn.neyzoter.exam.bilibili;


import java.util.Scanner;

/**
 * B站测试3
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public int GetFragment (String str) {
        // write code here
        if (str.length() == 0) {
            return 0;
        } else if (str.length() == 1) {
            return 1;
        } else {
            int num = 1;
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i) != str.charAt(i - 1)) {
                    num++;
                }
            }
            return str.length() / num;
        }
    }
}
