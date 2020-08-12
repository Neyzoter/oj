package cn.neyzoter.exam.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Test2
 * 2
 * 3 5
 * 1 0 1 0 0
 * 0 1 1 0 1
 * 0 0 1 0 1
 *
 * 80% AC
 * @author neyzoter
 */
public class Test2 {
    public static final int CAN_NOT = 0;
    public static final int CAN = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int step = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        if (row <= 0 || col <= 0) {
            System.out.println(1);
            return;
        }
        if (row == 1 && col == 1) {
            System.out.println(1);
        }
        if (step <= 0) {
            System.out.println(0);
        }
        int[][] steps = {{step, 0}, {-step, 0}, {0, step}, {0, -step}};
        int[][] ground = new int[row][col];
        boolean[][] arrived = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ground[i][j] = sc.nextInt();
                arrived[i][j] = false;
            }
        }
        arrived[0][0] = true;
        boolean can = canArrive(ground, arrived, steps, 0, 0, set);
        System.out.println(can ? 1 : 0);
    }

    public static boolean canArrive(int[][] ground, boolean[][] arrived, int[][] steps, int x, int y, HashSet<String> set) {
//        System.out.println(String.format("( %d , %d)", x, y));
        if (arrivedDest(ground, x, y)) {
            return true;
        }
        boolean can = false;
        for (int[] s : steps) {
//            System.out.println(Arrays.toString(s));
            int newX = x + s[0];
            int newY = y + s[1];
            String idx = String.format("%s_%s", newX, newY);
            if (set.contains(idx)) {
                continue;
            }
            set.add(idx);
            if (valid(ground, arrived, newX, newY)) {
                arrived[newX][newY] = true;
                can |= canArrive(ground, arrived, steps, newX, newY, set);
                arrived[newX][newY] = false;
            }
        }
        return can;
    }

    public static boolean valid(int[][] ground, boolean[][] arrived, int x, int y) {
        int row = ground.length;
        int col = ground[0].length;
        return x >= 0 && y >= 0 && x < row && y < col && (!arrived[x][y]) && (ground[x][y] == CAN);
    }

    public static boolean arrivedDest(int[][] ground, int x, int y) {
        int row = ground.length;
        int col = ground[0].length;
        return x == row - 1 && y == col - 1;
    }
}
