package cn.neyzoter.exam.duxiaoman;

import java.util.Scanner;

/**
 * AC 9%
 *
 * 3
 * 3 3
 * ###
 * #@*
 * ***
 * 3 4
 * ####
 * #@.*
 * **.*
 * 3 3
 * .#.
 * #@#
 * .#.
 *
 * 1
 * 0
 * -1
 * @author neyzoter
 */
public class Test2 {
    public static final char START = '@';
    public static final char CAN_BROKEN = '*';
    public static final char CAN_NOT_BROKEN = '#';
    public static final char PLANE = '.';
    public static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int x = 0, y = 0;
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                if (str.length() != m) {
                    i--;
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    char ch = str.charAt(j);
                    matrix[i][j] = ch;
                    if (ch == START) {
                        x = i;y = j;
                    }
                }
            }
            System.out.println(dfs(matrix, new Integer[n][m], new boolean[n][m], x, y));
        }
    }

    public static int dfs(char[][] matrix, Integer[][] res, boolean[][] arrived, int x, int y) {
        int num = getThisNum(matrix, x, y);
        if (res[x][y] != null) {
            return res[x][y];
        }
        if (checkBound(matrix, x, y) || num == -1) {
            return num;
        }
        int sum = -1;
        for (int[] dir : DIRECTION) {
            int newX = x + dir[0], newY = y + dir[1];
            if (arrived[newX][newY]) {
                continue;
            }
            arrived[newX][newY] = true;
            int next = dfs(matrix, res, arrived, newX, newY);
            if (next != -1) {
                if (sum == -1) {
                    sum = next;
                } else {
                    sum = Math.min(sum, next);
                }
            }
            arrived[newX][newY] = false;
        }
        if (sum == -1) {
            res[x][y] = sum;
        } else {
            res[x][y] = sum + num;
        }
        return res[x][y];
    }
    public static boolean checkBound(char[][] matrix, int x, int y) {
        return x == 0 || y == 0 || x == matrix.length - 1 || y == matrix[0].length - 1;
    }
    public static boolean valid(char[][] matrix, int x, int y) {
        return matrix[x][y] != CAN_NOT_BROKEN;
    }
    public static int getThisNum(char[][] matrix, int x, int y) {
        return matrix[x][y] == CAN_BROKEN ? 1 : (matrix[x][y] == CAN_NOT_BROKEN ? -1 : 0);
    }
    public static boolean idxValid(char[][] matrix, int x, int y) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
}
