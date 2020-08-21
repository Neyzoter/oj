package cn.neyzoter.exam.sensetime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 测试1
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1,3}};
        System.out.println(t.eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals (int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] i : intervals) {
            list.add(i);
        }
        int rmNum = 0;
        int[] x = makeX(list);
        while (!allZero(x)) {
            int maxIdx = getMax(x);
            list.remove(maxIdx);
            rmNum++;
            x = makeX(list);
        }
        return rmNum;
    }
    public int[] makeX(ArrayList<int[]> list) {
        int[] x = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int[] i1 = list.get(i);
                int[] i2 = list.get(j);
                if (i1[1] > i2[0]) {
                    x[i]++;
                    x[j]++;
                }
            }
        }
        return x;
    }

    public boolean allZero(int[] x) {
        for (int e : x) {
            if (e != 0) {
                return false;
            }
        }
        return true;
    }

    public int getMax(int[] x) {
        int max = x[0];
        int maxIdx = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i] > max) {
                maxIdx = i;
                max = x[i];
            }
        }
        return maxIdx;
    }
}
