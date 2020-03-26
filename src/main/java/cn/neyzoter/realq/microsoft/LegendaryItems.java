package cn.neyzoter.realq.microsoft;

import java.util.Scanner;

/**
 * 2017年 Legendary Items
 */
public class LegendaryItems {
    public static void main (String[] args) {
//        String[] strings = {"50","75", "2"};
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int P = Integer.parseInt(strings[0]);
        int Q = Integer.parseInt(strings[1]);
        int N = Integer.parseInt(strings[2]);
        System.out.println(dfs(P,N,Q,1,1,false)  + dfs(100-P,N,Q,0,1,true));
    }

    /**
     * deep first search
     * @return number of quests
     */
    public static double dfs (int P, int N, int Q, int quest, int deep, boolean noLegend) {
//        System.out.println(String.format("binary = %s , deep = %d, quest = %d, percent = %d",noLegend?"right":"left", deep, quest, P));
        if (quest == N) {
            return (double) deep * (double) P / 100.0;
        }
        int leftPercent;
        if (!noLegend) {
            leftPercent = P / (int) Math.pow(2, quest);
        } else {
            leftPercent = P + Q;
            if (leftPercent > 100) {
                leftPercent = 100;
            }
        }

        int rightPercent = 100 - leftPercent;

        if (rightPercent == 0) {
            return ( P / 100.0) * dfs(leftPercent, N, Q, quest + 1, deep + 1, false);
        } else {
            return ( P / 100.0) * (dfs(leftPercent, N, Q, quest + 1, deep + 1,false) + dfs(rightPercent, N, Q, quest , deep + 1, true));
        }

    }
}
