package cn.neyzoter.exam.alibaba.intern;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
         * 4 8 2
         * 1 2 4
         * 1 3 2
         * 1 4 7
         * 2 1 1
         * 2 3 5
         * 3 1 2
         * 3 4 4
         * 4 2 3
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


