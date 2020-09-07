package cn.neyzoter.exam.nvidia;

import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test3 {
    public static final int MAX_VAL = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[MAX_VAL];
        boolean[] tag = new boolean[MAX_VAL];
        int[] p = new int[MAX_VAL];
        int c = 0;
        int k;
        for (int i = 2; i < MAX_VAL; i++) {
            if (!tag[i]) {
                p[c] = i;
                c++;
                for (int j = 2 * i; j < MAX_VAL; j += i) {
                    tag[j] = true;
                }
            }
        }
        for (int i = 0; i < c; i++) {
            for (int j = i + 1; j < c; j++) {
                k = p[i] + p[j];
                if (k < MAX_VAL) {
                    a[k]++;
                } else {
                    break;
                }
            }
        }
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(a[n]);
        }

    }
}
