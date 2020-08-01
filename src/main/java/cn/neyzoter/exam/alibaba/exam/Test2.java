package cn.neyzoter.exam.alibaba.exam;

/**
 * 阿里巴巴测试
 * <pre>
 *     input: bx = 3 by = 1 ex = 1 ey = 3
 *     output: 14
 *     input: bx = 1 by = 1 ex = 3 ey = 4
 *     output: 13
 * </pre>
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        int n = 4,m = 4;
        char[][] map = {{'C', 'C', 'C', 'S'},{'S', 'S', 'S', 'S'},
                {'C', 'S', 'C', 'S'}, {'S', 'S', 'C', 'C'}};
        System.out.println(minLen(map, 3, 1, 1, 3));
    }

    public static int minLen(char[][] map, int bx, int by, int ex, int ey) {
        boolean[][] arived = new boolean[map.length][map[0].length];
        return minLen(map, arived, bx- 1, by - 1, ex - 1, ey - 1);
    }

    public static int minLen(char[][] map, boolean[][] arived, int bx, int by, int ex, int ey) {
        if (bx == ex && by == ey) {
            return 0;
        }
        // 四个方向
        int nx, ny;
        int p = Integer.MAX_VALUE;
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int i = 0; i < dir.length; i++) {
            int[] d = dir[i];
            nx = bx + d[0];
            ny = by + d[1];
            if (valid(map, arived, nx, ny)) {
                arived[nx][ny] = true;
                int np = minLen(map, arived, nx, ny, ex, ey);
                if (np != Integer.MAX_VALUE) {
                    np = np + power(map, bx, by, ex, ey);
                }
                p = Math.min(p, np) ;
                arived[nx][ny] = false;
            }
        }
        return p;
    }

    public static int power(char[][] map, int bx, int by, int ex, int ey){
        if (map[bx][by] != map[ex][ey]) {
            return 5;
        } else if (map[bx][by] == 'C') {
            return 3;
        } else {
            return 2;
        }
    }
    public static boolean valid(char[][] map, boolean[][] arived, int x, int y) {
        return (x >= 0) && (y >= 0) && (x < map.length) && (y < map[0].length) && (!arived[x][y]);
    }
}
