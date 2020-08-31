package cn.neyzoter.exam.littleredbook;

import java.util.Scanner;


/**
 * 7 7 3 3
 * 7 7 7 6 2 10 5
 * 5 8 8 2 1 6 2
 * 2 9 5 5 6 1 7
 * 7 9 3 6 1 7 8
 * 1 9 1 4 7 8 8
 * 10 5 9 1 1 8 10
 * 1 3 1 5 4 8 6
 *
 * 16
 *
 * AC 18%
 */
public class Test3 {
    static final int MAX_ROW_COL = 16;
    static int n, m, r, c;
    static long[][] matrix = new long[MAX_ROW_COL][MAX_ROW_COL];
    static long[][] func = new long[MAX_ROW_COL][MAX_ROW_COL];
    static long[] w = new long[MAX_ROW_COL];
    static long[][] v = new long[MAX_ROW_COL][MAX_ROW_COL];
    static int[] pre = new int[MAX_ROW_COL];
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        dfs(1, 1);
        System.out.println(ans);
    }

    public static void dfs(int x, int y) {
        if (y > r) {
            dp();
            return;
        }
        if (x > n) {
            return;
        }
        // 不选
        dfs(x + 1, y);
        // 在pre记录x
        pre[y] = x;
        // 选择
        dfs(x + 1, y + 1);
    }

    public static void dp() {
        int i, j, k;
        for (i = 0; i < MAX_ROW_COL; i++) {
            for (j = 0; j < MAX_ROW_COL; j++) {
                func[i][j] = 128;
                w[i] = 0;
                v[i][j] = 0;
            }
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j < r; j++) {
                w[i] = w[i] + Math.abs(matrix[pre[j]][i] - matrix[pre[j + 1]][i]);
            }
        }
        for (i = 1; i <= m; i++) {
            for (j = i + 1; j <= m; j++) {
                for (k = 1; k <= r; k++) {
                    v[i][j] = v[i][j] + Math.abs(matrix[pre[k]][i] - matrix[pre[k]][j]);
                }
            }
        }
        func[0][0] = 0;
        for (i = 1; i <= c; i++) {
            for (j = i; j <= m; j++) {
                for (k = 0; k < j; k++) {
                    func[i][j] = Math.min(func[i - 1][k] + w[j] + v[k][j], func[i][j]);
                }
            }
        }
        for (i = c; i <= m; i++) {
            ans = Math.min(ans, func[c][i]);
        }
    }
}

