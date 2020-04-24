package cn.neyzoter.exam.alibaba.intern;

import java.util.*;

/**
 * Alibaba Exam2<br/>
 * 注意类名必须为Main, 不要有任何package xxx信息
 * @author Charles Song
 * @date 2020-3
 */
public class Test2 {
    public static void main (String[] args) {
        /**
         * 测试样例
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();int m = sc.nextInt();int x = sc.nextInt();
            int[][] path = new int[m][3];
            for (int i = 0 ; i < m ; i++) {
                path[i][0] = sc.nextInt();
                path[i][1] = sc.nextInt();
                path[i][2] = sc.nextInt();
            }
            System.out.println("Dijkstra ...");
            Dijkstra dijkstra = new Dijkstra(n, m, x, path);
            dijkstra.findMax();
            System.out.println("Internal Func ...");
            maxLen(n, m, x, path);
        }
    }

    /**
     * 找到所有城市各自最小路径中的最大路径
     * @param n 城市个数
     * @param m 路径条数
     * @param x 参加聚会的城市
     * @param path 路径信息，包括起点、终点和长度
     */
    public static void maxLen (int n, int m, int x, int[][] path) {

        List<Integer> minList = new LinkedList<>();
        for (int city = 1; city <= n ; city ++) {
            List<Integer> list = new LinkedList<>();
            if (city != x) {
                findPath(city, city, x, false, false, 0, list, m, 0, path);
                int minLen = list.get(0);
                for (int item : list) {
                    if (minLen > item) {
                        minLen = item;
                    }
                }
                minList.add(minLen);
            }
        }
        int maxLen = minList.get(0);
        for (int item : minList) {
            if (maxLen < item) {
                maxLen = item;
            }
        }
        System.out.println(maxLen);

    }

    /**
     * 找到一个城市A经过目的城市B后回到城市A的所有路径长度
     * @param startCity 开始的城市A
     * @param nowCity 当前所在城市
     * @param destCity 目的城市B
     * @param started 离开城市A的标志位
     * @param arrived 已经到达过城市B的标志位
     * @param pathLen 路径长度
     * @param list 保存路径长度的列表
     * @param m 城市个数
     * @param layer 递归层数
     * @param path 路径信息，包括起点、终点和长度
     */
    public static void findPath (int startCity, int nowCity,int destCity, boolean started, boolean arrived, int pathLen, List<Integer> list ,int m, int layer, int[][] path){
        // 如果已经出发, 而且结束
        if (started && (startCity == nowCity)) {
            // 已经到达过目的city x
            if (arrived) {
                list.add(pathLen);
            }
            return;

        }
        // 递归层数太多，可能出现了环，直接退出递归
        if (layer > 2 * m) {
            return;
        }
        for (int idx = 0; idx < m ; idx ++) {
            int city = path[idx][0];
            int nextCity = path[idx][1];
            int len = path[idx][2];
            if (city == nowCity) {
                if (nextCity == destCity) {
                    arrived = true;
                }
                findPath(startCity, nextCity, destCity,true, arrived, pathLen + len,list, m, layer+1, path );
            }

        }
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
     * 目的地
     */
    public int dest;

    /**
     * scanner的路径信息
     */
    public int[][] path;

    /**
     * 连接图
     */
    public int[][] graph;
    Dijkstra (int cityNum, int roadNum, int dest, int[][] path) {
        this.cityNum = cityNum;
        this.roadNum = roadNum;
        this.dest = dest - 1;
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
            int source = this.path[i][0] - 1;
            int destination = this.path[i][1] - 1;
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
                boolean update = !used[j] && result[j] < min;
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

    public void findMax () {
        int max = NOT_CONNECT;
        int[] dest2sc = get(dest);
        for (int i = 0; i < cityNum; i ++) {
            int[] result = get(i);
            int len = result[dest] + dest2sc[i];
            if (len  > max) {
                max = len;
            }
        }
        if (max != NOT_CONNECT) {
            System.out.println(max);
        } else {
            System.out.println("Not Connect");
        }

    }
}


