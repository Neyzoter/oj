package cn.neyzoter.leetcode.algo.array;

import java.util.*;

/**
 * 207 课程表
 * @author neyzoter
 */
public class _207_ClassTable {
    public static void main(String[] args) {

    }
}

class Sol1_207_ClassTable {
    public final static int UN_VISITED = 0;
    public final static int VISITED = 1;
    public final static int OVER = 2;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        valid = true;
        List<List<Integer>> edge = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edge.get(info[1]).add(info[0]);
        }
        for (int num = 0; num < numCourses; num++) {
            dfs(num, visited, edge);
            if (!valid) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int num, int[] visited, List<List<Integer>> list) {
        visited[num] = VISITED;
        List<Integer> l = list.get(num);
        for (int c : l) {
            if (visited[c] == UN_VISITED) {
                dfs(c, visited, list);
                if (!valid) {
                    return;
                }
            } else if (visited[c] == VISITED) {
                valid = false;
                return;
            }
        }
        visited[num] = 2;
        return;
    }
}
