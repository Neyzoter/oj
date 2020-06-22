package cn.neyzoter.leetcode.algo.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * @author Charles Song
 * @date 2020-6-21
 */
public class _200_NumIslands {
    public static void main (String[] args) {
        char[][] ch = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }
}

class Sol1_200_NumIslands {
    public static char IS_LAND = '1';
    class Index {
        int i;
        int j;
        public Index (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (isLand(i, j, grid)) {
                    num ++;
                    Queue<Index> q = new LinkedList<>();
                    grid[i][j] = 0;
                    q.add(new Index(i, j));
                    for (;q.size() != 0;) {
                        Index idx = q.remove();
                        int x = idx.i;
                        int y = idx.j;
                        if (isLand(x - 1, y, grid)) {
                            grid[x - 1][y] = 0;
                            q.add(new Index(x - 1, y));
                        }
                        if (isLand(x, y - 1, grid)) {
                            grid[x][y - 1] = 0;
                            q.add(new Index(x, y - 1));
                        }
                        if (isLand(x + 1, y, grid)) {
                            grid[x + 1][y] = 0;
                            q.add(new Index(x + 1, y));
                        }
                        if (isLand(x, y + 1, grid)) {
                            grid[x][y + 1] = 0;
                            q.add(new Index(x, y + 1));
                        }
                    }
                }
            }
        }
        return num;
    }

    public static boolean isLand (int i, int j, char[][] grid) {
        if (i >= 0 && i < grid.length) {
            if (j >=0 && j < grid[0].length) {
                return grid[i][j] == IS_LAND;
            }
        }
        return false;
    }

}