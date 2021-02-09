package cn.neyzoter.leetcode.algo.array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _57_InsertRange {
    public static void main(String[] args) {

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length + 1][2];
        if (temp.length == 1) {
            temp[0] = newInterval;
            return temp;
        }
        List<int[]> res = new LinkedList<>();
        boolean inserted = false;
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0] && !inserted) {
                temp[j] = newInterval;j++;
                inserted = true;
            }
            temp[j] = intervals[i];j++;
        }
        if (!inserted) {
            temp[temp.length - 1] = newInterval;
        }
        int[] last = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (last[1] < temp[i][0]) {
                res.add(last);
                last = temp[i];
            } else if (last[1] < temp[i][1]) {
                last[1] = temp[i][1];
            }
            if (i == temp.length - 1) {
                res.add(last);
            }
        }
        int[][] resArray = new int[res.size()][2];
        Iterator<int[]> iter = res.iterator();
        int idx = 0;
        while (iter.hasNext()) {
            int[] i = iter.next();
            resArray[idx++] = i;
        }
        return resArray;
    }
}
