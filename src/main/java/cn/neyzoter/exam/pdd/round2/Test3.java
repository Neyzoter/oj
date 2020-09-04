package cn.neyzoter.exam.pdd.round2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * pdd测试3
 * AC 60%
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Wnumber = sc.nextInt();
        int maxC = sc.nextInt();
        int[] weight = new int[Wnumber];
        int[] value = new int[Wnumber];
        for (int i = 0; i < Wnumber; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        int[][] V = new int[Wnumber + 1][maxC + 1];
        for (int i = 0; i < Wnumber + 1; i++) {
            V[i][0] = 0;
        }
        for (int i = 0; i < maxC; i++) {
            V[0][i] = 0;
        }
        for (int i = 1; i <= Wnumber; i++) {
            for (int j = 1; j <= maxC; j++) {
                if (weight[i - 1] <= j) {
                    if (V[i - 1][j] < V[i - 1][j - weight[i - 1]] + value[i - 1]) {
                        V[i][j] = V[i - 1][j - weight[i - 1]] + value[i - 1];
                    } else {
                        V[i][j] = V[i - 1][j];
                    }
                } else {
                    V[i][j] = V[i - 1][j];
                }
            }
        }
        System.out.println(V[Wnumber][maxC]);
    }
}
