package cn.neyzoter.leetcode.algo.array;

/**
 * 37. 解数独
 * @author Charles Song
 * @date 2020-7-3
 */
public class _37_SolveSudoku {
    public static void main (String[] args) {

    }
}

/**
 * 时间复杂度（最坏）：O(9^M)，M表示空出来的格子个数
 */
class Sol1_37_SolveSudoku {
    public void solveSudoku(char[][] board) {
        sol(board, 0, 0);
    }

    public static boolean sol(char[][] board, int is, int js) {
        int h = board.length;
        int w = board[0].length;
        if (is >= h || js >= w) {
            return true;
        }
        if (board[is][js] == '.') {
            for (char n = '1'; n <= '9'; n ++) {
                board[is][js] = n;
                if (isOneValid(board, is , js) && isFullValid(board, is, js)) {
                    if (js == w - 1) {
                        if (sol(board, is + 1, 0)) {
                            return true;
                        }
                    } else {
                        if (sol(board, is, js + 1)) {
                            return true;
                        }
                    }
                }
                board[is][js] = '.';
            }
        } else {
            if (js == w - 1) {
                return sol(board, is + 1, 0);
            } else {
                return sol(board, is, js + 1);
            }
        }

        return false;
    }
    public static boolean isOneValid(char[][] board, int x, int y) {
        int is = x / 3 * 3;
        int js = y / 3 * 3;
        for (int i = is; i < is + 3; i ++) {
            for (int j = js; j < js + 3; j ++) {
                if (i == x && j == y) {
                    continue;
                }
                if (board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean isFullValid(char[][] board, int x, int y) {
        int h = board.length;
        int w = board[0].length;
        for (int i = 0; i < h; i ++) {
            if (i == x) {
                continue;
            }
            if (board[i][y] == board[x][y]) {
                return false;
            }
        }

        for (int j = 0; j < w; j ++) {
            if (j == y) {
                continue;
            }
            if (board[x][j] == board[x][y]) {
                return false;
            }
        }

        return true;
    }
}
