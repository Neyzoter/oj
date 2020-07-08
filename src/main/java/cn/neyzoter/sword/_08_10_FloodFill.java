package cn.neyzoter.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题 08.10. 颜色填充
 * @author Charles Song
 * @date 2020-7-8
 */
public class _08_10_FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        Sol1_08_10_FloodFill sol = new Sol1_08_10_FloodFill();
        sol.floodFill(image, 1, 1, 2);
    }
}

class Sol1_08_10_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(sr, sc));
        visited[sr][sc] = true;
        int val = image[sr][sc];
        while (queue.size() > 0) {
            int num = queue.size();
            for (int i = 0; i < num; i ++) {
                Index idx = queue.remove();
                int r = idx.sr;
                int c = idx.sc;
                // 更改
                image[r][c] = newColor;
                int[] rarr = {r - 1, r + 1};
                int[] carr = {c - 1, c + 1};
                for (int ri : rarr) {
                    addQ(ri, c, image, visited, val, queue);
                }
                for (int ci : carr) {
                    addQ(r, ci, image, visited, val, queue);
                }

            }
        }
        return image;
    }
    public void addQ(int sr, int sc, int[][] image, boolean[][] visited, int val, Queue<Index> queue) {
        if (checkValid(sr, sc, image) && !visited[sr][sc] && image[sr][sc] == val) {
            queue.add(new Index(sr, sc));
            visited[sr][sc] = true;
        }
    }
    public boolean checkValid(int sr, int sc, int[][] image) {
        return sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length;
    }

    class Index {
        private int sr;
        private int sc;
        public Index(int r, int c) {
            sr = r;
            sc = c;
        }
        public int setSr(int s) {
            sr = s;
            return sr;
        }
        public int getSr() {
            return sr;
        }
        public int setSc(int s) {
            sc = s;
            return sc;
        }
        public int getSc() {
            return sc;
        }
    }
}