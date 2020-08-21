package cn.neyzoter.exam.sensetime;

import java.util.Scanner;

/**
 * 测试1
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (row <= 0 || col <= 0) {
            System.out.println(0);
            return;
        }
        int[][] matrix = new int[row][col];
        int[][] len = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
                len[i][j] = 0;
            }
        }
        int maxPath = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxPath = Math.max(track(matrix, len, i, j), maxPath);
            }
        }
        System.out.println(maxPath);
    }

    public static int track(int[][] matrix, int[][] len, int i, int j) {
        if (len[i][j] != 0) {
            return len[i][j];
        }
        int[][] step = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
        int num = 1;
        int next = 0;
        for (int[] s : step) {
            int newI = s[0];
            int newJ = s[1];
            if (valid(matrix, i, j, newI, newJ)) {
                next = Math.max(track(matrix, len, newI,  newJ), next);
            }
        }
        num += next;
        len[i][j] = num;
        return num;
    }

    public static boolean valid(int[][] matrix, int si, int sj, int ni, int nj) {
        boolean outOfBound = ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[0].length;
        if (!outOfBound) {
            return matrix[si][sj] < matrix[ni][nj];
        }
        return false;
    }
}
