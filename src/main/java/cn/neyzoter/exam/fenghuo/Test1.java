package cn.neyzoter.exam.fenghuo;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.Scanner;

/**
 * input 1101010110010110
 * output 8
 * @author neyzoter
 */
public class Test1 {
    public static final int START = 1;
    public static final int ONE = 1 << 1;
    public static final int ONE_ONE = 1 << 2;
    public static final int ONE_ONE_ZERO = 1 << 3;

    public static int state = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        state = 1;
        int res = 0;
        int temp = 0;
        for (int i = 0 ; i < str.length(); i++) {
            char ch = str.charAt(i);
            stateChange(ch);
            if (state == ONE_ONE_ZERO) {
                state = START;
                temp = 2;
            } else {
                temp++;
            }
            res = Math.max(temp, res);
        }
        System.out.println(res);
    }
    public static void stateChange(char ch) {
        switch (ch) {
            case '1':
                if (state == START) {
                    state = ONE;
                } else if (state == ONE) {
                    state = ONE_ONE;
                } else if (state == ONE_ONE) {
                    break;
                } else {
                    state = START;
                }
                break;
            case '0':
                if (state == ONE_ONE) {
                    state = ONE_ONE_ZERO;
                } else {
                    state = START;
                }
                break;
            default:
                break;
        }
    }
}
