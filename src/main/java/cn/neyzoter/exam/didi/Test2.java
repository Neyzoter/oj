package cn.neyzoter.exam.didi;

import java.util.Scanner;

/**
 * Test2
 * <pre>
 *
 * 2、小明昨晚做了一个梦。在梦里，很多很多斐波那契数连成了一条蛇。突然，最大的那个数变成了蛇头，把小明一口给吞到肚子里去了。
 *
 * 小明被吓醒了，他赶紧拿笔在纸上面画了一条斐波那契蛇。
 *
 * 这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
 *
 * 下面是n=4时的情况：
 *
 * 小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。
 *
 *
 * 输入描述
 * 单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)
 *
 * 输出描述
 * 输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。
 *
 * 样例输入
 * 3
 * 样例输出
 * 34 21 13
 * 1 1 8
 * 2 3 5
 * </pre>
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long[] fib = new long[100];
        fib[0] = fib[1] = 1;
        for (int i = 2; i < n * n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int idx = n * n - 1;
        long[][] matrix = new long[n][n];
        int x = 0, y = 0, w = 0;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        // 遍历所有节点
        while (idx >= 0) {
            // 判断是否越界
            while (x >= 0 && x < n && y >= 0 && y < n) {
                if (matrix[x][y] == 0) {
                    matrix[x][y] = fib[idx--];
                } else {
                    break;
                }
                x += dx[w % 4];
                y += dy[w % 4];
            }
            x -= dx[w % 4];
            y -= dy[w % 4];
            w++;
            x += dx[w % 4];
            y += dy[w % 4];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][0]);
            for (int j = 1;j < n; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
