package cn.neyzoter.exam.yitu;

import java.util.Scanner;

/**
 * AC 100%
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lastTi = sc.nextInt();
        int lastXi = sc.nextInt();
        int lastYi = sc.nextInt();
        int lastZi = sc.nextInt();
        Double biggestDis = null;
        int segMax = 1;
        for (int i = 0; i < n - 1; i++) {
            int thisTi = sc.nextInt();
            int thisXi = sc.nextInt();
            int thisYi = sc.nextInt();
            int thisZi = sc.nextInt();
            int deltaTi = thisTi - lastTi;
            int deltaXi = thisXi - lastXi;
            int deltaYi = thisYi - lastYi;
            int deltaZi = thisZi - lastZi;
            double thisDis = distance(deltaXi, deltaYi, deltaZi, deltaTi);
            if (biggestDis != null) {
                double rate = thisDis / biggestDis;
                if (rate > 1 ) {
                    segMax = i + 1;
                    biggestDis = thisDis;
                }
            } else {
                biggestDis = thisDis;
            }
            lastXi = thisXi;lastTi = thisTi;lastYi = thisYi;lastZi = thisZi;
        }
        System.out.print(segMax);
    }
    public static double distance(int deltaXi, int deltaYi, int deltaZi, int deltaTi) {
        return (double) (deltaXi * deltaXi + deltaYi * deltaYi + deltaZi * deltaZi) / (double) deltaTi;
    }
}
