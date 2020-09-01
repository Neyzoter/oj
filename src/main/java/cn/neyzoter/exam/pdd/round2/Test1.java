package cn.neyzoter.exam.pdd.round2;

import java.util.Scanner;

/**
 * pdd测试1
 * AC 100%
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int matrixN = n;
//        if (n % 2 == 0) {
//            matrixN = n + 1;
//        }
        int[][] matrix = new int[n][n];
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            for (int j = i + 1; j < mid; j++) {
                matrix[i][j] = 2;
                matrix[i][n - 1 - j] = 1;
                matrix[j][i] = 3;
                matrix[n - 1 - j][i] = 4;
                matrix[n - 1 - i][j] = 5;
                matrix[n - 1 - i][n - 1 - j] = 6;
                matrix[n - 1 - j][n - 1 - i] = 7;
                matrix[j][n - 1 - i] = 8;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j == n - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
//        int mid = matrixN / 2;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == j || i == mid || j == mid) {
//                    matrix[i][j] = 0;
//                } else {
//
//                }
//            }
//        }
    }
//    public static int getNum(int x, int y, int mid) {
//        x = x - mid;
//        y = y - mid;
//
//    }
}
