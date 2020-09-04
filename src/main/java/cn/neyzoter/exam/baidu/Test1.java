package cn.neyzoter.exam.baidu;

import java.util.Scanner;

/**
 * Test1
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        Integer[] num = new Integer[n];
        int num5 = 0;
        int num0 = 0;
        for (int i = 0; i < n; i++) {
//            num[i] = sc.nextInt();
            int num = sc.nextInt();
            if (num == 5) {
                num5++;
            } else if (num == 0) {
                num0++;
            }
        }
//        Arrays.sort(num, Collections.reverseOrder());
        if (num0 > 0 && num5 >= 9) {
            int num5t = num5 / 9 * 9;
            for (int i = 0; i < num5t; i++) {
                System.out.print(5);
            }
            for (int i = 0; i < num0; i++) {
                System.out.print(0);
            }
        } else if (num0 > 0) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }

    }

}
