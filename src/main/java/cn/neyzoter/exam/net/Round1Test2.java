package cn.neyzoter.exam.net;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 数字圆环
 * https://www.nowcoder.com/questionTerminal/4b9d1cde452d43a282fad4ff8b2559ea
 * <pre>
 * 输入：
 * 1
 * 5
 * 17 6 17 11 17
 * 输出：
 * YES
 *
 * 输入
 * 1
 * 3
 * 1 2 4
 *
 * 输出：
 * NO
 * </pre>
 */
public class Round1Test2 {
    public static void main(String[] args) {
        int[] circle = {17, 6, 17, 11, 17};
        System.out.print(check(circle));
    }

    public static boolean check(int[] circle) {
        Arrays.sort(circle);
        if (circle[circle.length - 1] < circle[circle.length - 2] + circle[0]) {
            return true;
        } else if (circle.length > 3) {
            return circle[circle.length - 1] < circle[circle.length - 2] + circle[circle.length - 3];
        }
        return false;
    }
}
