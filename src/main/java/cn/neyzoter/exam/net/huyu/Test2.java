package cn.neyzoter.exam.net.huyu;

import java.util.*;

/**
 * AC 50%
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // 列数
            int W = sc.nextInt();
            // 行数
            int H = sc.nextInt();
            char[][] bg = new char[H][W];
            for (int h = 0; h < H; h++) {
                String str = sc.nextLine();
                if (str.length() == 0) {
                    h--;
                    continue;
                }
                for (int w = 0; w < W; w++) {
                    bg[h][w] = str.charAt(w);
                }
            }
            // 列数
            int P = sc.nextInt();
            // 行数
            int Q = sc.nextInt();
            char[][] pic = new char[Q][P];
            for (int q = 0; q < Q; q++) {
                String str = sc.nextLine();
                if (str.length() == 0) {
                    q--;
                    continue;
                }
                for (int p = 0; p < P; p++) {
                    pic[q][p] = str.charAt(p);
                }
            }
            // 初始i
            int i = sc.nextInt();
            // 初始j
            int j = sc.nextInt();
            // 每次向右边移动a
            int a = sc.nextInt();
            // 每次向下边移动b
            int b = sc.nextInt();
            for (;!cover(i, j, P, Q, H, W);) {
                i += a;
                b += b;
            }
            System.out.println(refresh(i, j, a, b, P, Q, H, W, pic, bg));
        }
    }
    public static int refresh(int i, int j, int a, int b, int P, int Q, int H, int W, char[][] pic, char[][] bg) {
        if (!cover(i, j, P, Q, H, W)) {
            return 0;
        }
        int ref = 0;
        for (int x = 0; x <= P; x++) {
            for (int y = 0; y <= Q; y++) {
                char bgch = bg[x][y];
                if (valid(x - i + 1, y - j + 1, pic)) {
                    char pich = pic[x - i + 1][y - j + 1];
                    if (bgch != pich) {
                        ref++;
                    }
                }
            }
        }
        return ref + refresh(i + a, j + b, a, b, P, Q, H, W, pic, bg);
    }
    public static boolean valid(int x, int y, char[][] matrix) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
    public static boolean cover(int i, int j, int P, int Q, int H, int W) {
        return !((i + P) < 1 || (j + Q) < 1 || i > W + 1 || j > H + 1);
    }
}
