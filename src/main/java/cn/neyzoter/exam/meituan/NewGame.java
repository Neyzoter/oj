package cn.neyzoter.exam.meituan;

import java.util.*;

/**
 * 6 6 20 10
 * S#++O#
 * OXX#X#
 * ++++++
 * ###XX#
 * ++#O#+
 * OXO++X
 * SSDDDDDAWWSSSAWSSSADDD
 * @author neyzoter
 */
public class NewGame {
    public static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();int m = sc.nextInt();
        int p = sc.nextInt();int q = sc.nextInt();
        char[][] matrix = new char[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            if (str.length() != m) {
                i--;
                continue;
            }
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j);
                // 找到了起始位置
                if (matrix[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        String path = sc.nextLine();
        long res = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            // 获取方向
            int[] dir = dir(ch);
            int newX = x + dir[0];
            int newY = y + dir[1];
            // 非墙壁，非边界
            if (valid(newX, newY, matrix)) {
                x = newX; y = newY;
                long s = score(x, y, matrix, p, q);
                res += s;
                matrix[x][y] = '+'; // 奖励和代价都只需要一次
            }
        }
        System.out.println(res);
    }
    public static int[] dir(char ch) {
        switch (ch) {
            case 'W': // 上
                return DIRECTION[0];
            case 'S': //下
                return DIRECTION[1];
            case 'A': //左
                return DIRECTION[2];
            case 'D': // 右
                return DIRECTION[3];
            default: // 不可能进入
                return DIRECTION[3];
        }
    }
    public static boolean valid(int x, int y, char[][] matrix) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && // 走出边界
                matrix[x][y] != '#'; // 墙壁
    }
    public static long score(int x, int y, char[][] matrix, int p, int q) {
        char ch = matrix[x][y];
        if (ch == 'O') { // O
            return p;
        } else if (ch == 'X') { // X
            return -q;
        } else { // +
            return 0;
        }
    }
}
