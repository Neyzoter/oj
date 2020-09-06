package cn.neyzoter.exam.tencent;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrn = new int[n];
        for (int i = 0; i < n; i++) {
            arrn[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arrm = new int[m];
        for (int i = 0; i < m; i++) {
            arrm[i] = sc.nextInt();
        }
        int nptr = 0, mptr = 0;
        List<Integer> list = new LinkedList<>();
        while (nptr < n && mptr < m) {
            if (arrn[nptr] > arrm[mptr]) {
                nptr++;
            } else if (arrn[nptr] < arrm[mptr] ) {
                mptr++;
            } else {
                list.add(arrm[mptr]);
                mptr++;nptr++;
            }
        }
        for (int i : list) {
            System.out.print(i);
            n--;
            if (n != 0) {
                System.out.print(" ");
            }
        }

    }
}
