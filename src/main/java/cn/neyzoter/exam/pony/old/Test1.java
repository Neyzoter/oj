package cn.neyzoter.exam.pony.old;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T -- > 0) {
            int advx1 = sc.nextInt(), advy1 = sc.nextInt(), advx2 = sc.nextInt(), advy2 = sc.nextInt(), tmp;
            if(advx1 > advx2)  { tmp = advx1;  advx1 = advx2; advx2 = tmp; }
            if(advy1 > advy2)  { tmp = advy1;  advy1 = advy2; advy2 = tmp; }
            int carheady = advy2;
            int n = sc.nextInt();
            double[] miny = new double[n];
            for(int i = 0; i < n; i ++)
                miny[i] = Double.MAX_VALUE;
            for(int i = 0; i < n; i ++) {
                int m = sc.nextInt();
                int[][] line = new int[m + 1][2];
                int minx = Integer.MAX_VALUE, maxx = Integer.MIN_VALUE;
                double _miny = Double.MAX_VALUE;
                for(int j = 0; j < m; j ++) {
                    line[j][0] = sc.nextInt();  line[j][1] = sc.nextInt();
                    minx = (minx > line[j][0]) ? line[j][0] : minx;
                    maxx = (maxx < line[j][0]) ? line[j][0] : maxx;
                }
                line[m][0] = line[0][0];  line[m][1] = line[0][1];
                for(int j = 0; j < m; j ++) {
                    if(line[j][0] == line[j + 1][0])  continue;
                    else if(Math.max(line[j][0], line[j + 1][0]) <= advx1 || Math.min(line[j][0], line[j + 1][0]) >= advx2 || (line[j][0] >= advx1 && line[j][0] <= advx2 && line[j + 1][0] >= advx1 && line[j + 1][0] <= advx2))  continue;
                    double k = 1.0 * (line[j + 1][1] - line[j][1]) / (line[j + 1][0] - line[j][0]);
                    double b = line[j][1] - k * line[j][0];
                    double y = (k < 0) ? (advx2 * k + b) : (advx1 * k + b);
                    if(_miny > y) {
                        _miny = y;
                        miny[i] = y - carheady;
                    }
                }
            }
            Arrays.parallelSort(miny);
            int count = 0;
            for(int i = 0; i < n; i ++)
                if(miny[i] < Double.MAX_VALUE)  count ++;
            System.out.println(count);
            for(int i = 0; i < n; i ++)
                if(miny[i] < Double.MAX_VALUE)
                    System.out.printf("%.9f\n", miny[i]);
        }
    }

}
