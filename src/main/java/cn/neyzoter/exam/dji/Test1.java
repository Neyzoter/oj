package cn.neyzoter.exam.dji;

import java.util.Arrays;
import java.util.Scanner;

/**
 * AC 60%
 */
public class Test1 {
    public static final int NOT_L = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[][] path = new int[p][3];
        // 设置连通的路径
        int idx = 0;
        while (idx < p) {
            path[idx][0] = sc.nextInt();
            path[idx][1] = sc.nextInt();
            path[idx][2] = sc.nextInt();
            idx++;
        }
        int x = sc.nextInt();
        Dijkstra dijkstra = new Dijkstra(n, p, path);
        int[] result = dijkstra.get(0);
        System.out.print(result[x]);
    }
}

class Dijkstra {
    /**
     * 不连通
     */
    public static final int NOT_CONNECT = -1;
    /**
     * 城市数量
     */
    public int cityNum;
    /**
     * 路径数量
     */
    public int roadNum;

    /**
     * scanner的路径信息
     */
    public int[][] path;

    /**
     * 连接图
     */
    public int[][] graph;
    Dijkstra (int cityNum, int roadNum, int[][] path) {
        this.cityNum = cityNum;
        this.roadNum = roadNum;
        this.path = path;
        this.graph = new int[cityNum][cityNum];
        // 初始值
        for (int i = 0; i < cityNum; i ++) {
            for (int j = 0; j < cityNum; j ++) {
                if (i == j ) {
                    this.graph[i][j] = 0;
                } else {
                    this.graph[i][j] = NOT_CONNECT;
                }

            }
        }
        // 初始化
        for (int i = 0; i < roadNum; i ++) {
            int source = this.path[i][0];
            int destination = this.path[i][1];
            int len = this.path[i][2];
            this.graph[source][destination] = len;
        }
    }

    /**
     * 运行Dijstra算法
     * @param source 起始地
     */
    public int[] get (int source) {
        boolean[] used = new boolean[cityNum];
        int[] result = new int[cityNum];
        // 初始化权值
        for (int i = 0; i < cityNum; i ++) {
            used[i] = false;
            result[i] = this.graph[source][i];
        }
        // 更新
        for (int i = 0; i < cityNum; i ++) {
            long min = Long.MAX_VALUE;
            int idx = -1;
            // 找到最小的
            for (int j = 0; j < cityNum; j ++) {
                // 未被使用
                boolean update = !used[j] && result[j] < min && result[j] != NOT_CONNECT;
                if (update) {
                    idx = j;
                    min = result[j];
                }
            }
            // 如果找到了最小
            if (idx != -1) {
                used[idx] = true;
                for (int j = 0; j < cityNum; j ++) {
                    int len = this.graph[idx][j];
                    // 长度不是未连接  新的长度小于原来的  或者原来的是未连接状态
                    boolean update = len != NOT_CONNECT && (result[j] > min + len || result[j] == NOT_CONNECT);
                    if (update) {
                        result[j] = (int)min + len;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }
}
