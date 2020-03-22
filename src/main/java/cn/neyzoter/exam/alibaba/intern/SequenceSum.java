package cn.neyzoter.exam.alibaba.intern;

import java.util.Scanner;

public class SequenceSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int N = Integer.parseInt(strings[0]);
        int L = Integer.parseInt(strings[1]);
        SequenceSum.printSequence(N,L);
    }

    public static void printSequence(int N, int L) {
        for (int l = L; l <= 100; l++) {
            double xDouble = (N - (l - 1.0) * l / 2.0)/l;
            if (xDouble < 0) {
                continue;
            }
            double xDIntDouble = (double)((int)xDouble);
            if (xDouble == xDIntDouble) {
                int x = (int)xDouble;
                for (int i = 0; i < l ; i ++) {
                    System.out.print(x + i);
                    if (i != l - 1) {
                        System.out.print(" ");
                    }
                }
                return;
            }
        }
        System.out.print("No");
    }
}
