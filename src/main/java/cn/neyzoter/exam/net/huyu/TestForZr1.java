package cn.neyzoter.exam.net.huyu;

import java.util.*;

/**
 * Todo
 * @author neyzoter
 */
public class TestForZr1 {
    public static int START = 0;
    public static int STOP = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int segNum = sc.nextInt();
        int n = sc.nextInt();
        double[][] pos = new double[n][2];
        double[] len = new double[n - 1];
        // 第i个pos和i-1个pos的长度, <i, len{i, i-1}>
//        HashMap<Integer, Double> len = new HashMap<>();
        double sumLen = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] strs = line.split(",", 2);
            try {
                pos[i][0] = Double.parseDouble(strs[0]);
                pos[i][1] = Double.parseDouble(strs[1]);
                if (i > 0) {
                    double l = computeLen(pos, i);
                    sumLen += l;
                    len[i - 1] = l;
                }
            } catch (NumberFormatException e) { // 处理异常
                System.out.println("error");
                return;
            }
        }
        double aveLen = sumLen / segNum;
        int seg = 1;
        double lenTemp = 0;
        for (int i = 0; i < n - 1; ) {
            if (lenTemp > aveLen * seg) {
                double[] pos1 = pos[i];
                double[] pos2 = pos[i + 1];
                double x = pos1[0] + (pos2[0] - pos1[0]) * (lenTemp - aveLen * seg) / len[i];
                double y = pos1[1] + (pos2[1] - pos1[1]) * (lenTemp - aveLen * seg) / len[i];
                System.out.println(String.format("%.1f %.1f", x, y));
                seg++;
            } else {
                lenTemp += len[i];
                i++;
            }
        }
    }

    // 求前一个pos之间的长度
    public static double computeLen(double[][] pos, int i) {
        return Math.sqrt(Math.pow(pos[i][0] - pos[i - 1][0], 2) + Math.pow(pos[i][1] - pos[i - 1][1], 2));
    }
}

/*
4
1 1 0
2 2 0
6 2 1
7 1 1

2
 */

/*
8
1 1 0
5 2 0
10 3 0
20 3 1
25 4 0
40 4 1
1000 2 1
2000 1 1

1
 */

/*
3
1 1 0
2 2 0
7 1 1

error
 */

/*
2
1 1 0
1 2 0

error
 */