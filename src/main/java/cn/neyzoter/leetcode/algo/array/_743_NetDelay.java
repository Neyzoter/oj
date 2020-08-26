package cn.neyzoter.leetcode.algo.array;

/**
 * AC 100%
 * leetcode 743
 * @author neyzoter
 */
public class _743_NetDelay {
    public static void main(String[] args) {
//        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int[][] times = {{1, 2, 1}};
        Sol_743_NetDelay sol = new Sol_743_NetDelay();
        int max = sol.networkDelayTime(times, 2, 1);
        System.out.println(max);
    }
}

class Sol_743_NetDelay {
    public static final int NOT_CONN = -1;
    public static final int FIRST_NUM = 1;
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] am = toAdjacencyMatrix(times, N, false);
        return dijkstra(am, N, K);
    }

    /**
     * 转化为邻接矩阵
     * @param m [origin, destination, power] 源头，目的地，权重
     * @param n 地点个数
     * @param de 是否双向
     * @return 邻接矩阵
     */
    public int[][] toAdjacencyMatrix(int[][] m, int n, boolean de) {
        int[][] matrix = new int[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = NOT_CONN;
                }

            }
        }
        // 路径填充
        for (int i = 0; i < m.length; i++) {
            int[] path = m[i];
            int s1 = m[i][0];
            int s2 = m[i][1];
            int power = m[i][2];
            matrix[s1 - FIRST_NUM][s2 - FIRST_NUM] = power;
            // 是否双向
            if (de) {
                matrix[s2 - FIRST_NUM][s1 - FIRST_NUM] = power;
            }
        }
        return matrix;
    }

    /**
     * 狄杰斯特拉计算最长路径，如果有断开的则返回-1
     * @param m 邻接矩阵
     * @param n 地点个数
     * @param k 起始地点
     * @return 最小路径
     */
    public int dijkstra(int[][] m, int n, int k) {
        int[] path = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            path[i] = NOT_CONN;
        }
        path[k - FIRST_NUM] = 0;
        used[k - FIRST_NUM] = true;
        // 初始化路径长度
        path = m[k - FIRST_NUM].clone();
        for (int i = 0; i < n; i++) {
            // 最小的数值idx
            int idx = NOT_CONN;
            for (int j = 0; j < n; j++) {
                // 未使用 && 而且是连接到 && (最小值)
                // 更新最小值
                if (!used[j] && path[j] != NOT_CONN && (idx == NOT_CONN || path[idx] > path[j])) {
                    idx = j;
                }
            }
            // 如果没有找到最小的可以直接退出
            if (idx == NOT_CONN) {
                break;
            }
            used[idx] = true;
            int[] idxp = m[idx];
            // path中最小的路径长度
            int min = path[idx];
            for (int j = 0; j < n; j++) {
                // idx -> j的距离
                int p = idxp[j];
                // 联通的
                if (p != NOT_CONN) {
                    // 从k 到 idx 到 j的举例
                    int pk2idx2j = min + p;
                    // 如果路径变小则更新
                    if (pk2idx2j < path[j] || path[j] == NOT_CONN) {
                        path[j] = pk2idx2j;
                    }
                }
            }
        }
        int maxPath = NOT_CONN;
        for (int i = 0; i < n ; i++) {
            if (i == k - FIRST_NUM) {
                continue;
            }
            if (path[i] != NOT_CONN && (maxPath == NOT_CONN || maxPath < path[i])) {
                maxPath = path[i];
            } else if (path[i] == NOT_CONN) { // 只要有一个是NOT_CONN则返回，认为不能到达
                return NOT_CONN;
            }
        }
        return maxPath;
    }
}