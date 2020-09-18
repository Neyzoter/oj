package cn.neyzoter.exam.yitu;

import java.util.Scanner;

/**
 * AC 0
 */
public class Test2 {
    public static final char CAN_ARRIVE = 'o';
    public static final char CAN_NOT_ARRIVE = 'x';
    public static final int[][] path = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int idx = 1;
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] abcd = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                if (str.length() < m) {
                    i--;
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = str.charAt(j);
                }
            }
            System.out.println("Case #" + idx + ": " + dfs(abcd, matrix, new Integer[n][m], new boolean[n][m], 0, 0, x, y));
            idx++;
        }
    }

    public static int dfs(int[] abcd, char[][] matrix, Integer[][] minAbcd, boolean[][] arrived, int i, int j, int x, int y) {
        if (x == i && y == j) {
            return 0;
        }
        if (minAbcd[i][j] != null) {
            return minAbcd[i][j];
        }
        int minPath = -1;
        for (int n = 0; n < 4; n++) {
            int abcdVal = abcd[n];
            int newI = i + path[n][0];
            int newJ = j + path[n][1];
            if (check(matrix, arrived, newI, newJ)) {
                arrived[newI][newJ] = true;
                int val = dfs(abcd, matrix, minAbcd, arrived, newI, newJ, x, y);
                if (val != -1) {
                    minPath = minPath == -1 ? val + abcdVal : Math.min(val + abcdVal, minPath);
                }
                arrived[newI][newJ] = false;
            }
        }
        minAbcd[i][j] = minPath;
        return minPath;
    }
    public static boolean check(char[][] matrix, boolean[][] arrived, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length && matrix[i][j] != CAN_NOT_ARRIVE && !arrived[i][j];
    }
}
