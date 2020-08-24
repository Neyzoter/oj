package cn.neyzoter.exam.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Test1
 * <pre>
 *
 * 1、设a，b，c是0到9之间的整数（其中a，b，c互不相同），
 * 其中abc和acc是两个不同的三位数，现给定一正整数n，
 * 问有多少对abc和acc能满足abc+acc=n（a≠0）？
 * 输入描述
 * 一个正整数n（100<n<2000）。
 * 输出描述
 * 第一行输出有多少对满足要求的数字。
 * 接下来每一行输出一对abc和acc，以空格分隔。
 * 如果没有一对abc和acc的话，则直接输出0即可。如果有多对，请按照abc升序的次序输出。
 * 样例输入
 * 1068
 * 样例输出
 * 1
 * 524 544
 * </pre>
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 200) {
            System.out.println(0);
            return;
        }
        int m = n;
        int a = n / 200;
        n = n - a * 200;
        List<Integer> list = new ArrayList<>();
        for (int b = 0; b < 10; b++) {
            if (b == a || n <= b * 10) {
                continue;
            }
            if ((n - b * 10) % 12 == 0) {
                int c = (n - b * 10 ) / 12;
                if (c != b && c != a && c < 10) {
                    list.add(a * 100 + b * 10 + c);
                }
            }
        }
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i + " " + (m - i));
        }

    }
}
