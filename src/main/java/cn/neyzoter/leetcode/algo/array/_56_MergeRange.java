package cn.neyzoter.leetcode.algo.array;

import scala.Int;

import java.util.*;

/**
 * 56. 合并区间
 * @author Charles Song
 * @date 2020-6-29
 */
public class _56_MergeRange {
    public static void main (String[] args) {
        int[][] intervals = {{2,6},{1,3},{8,10},{15,18}};
        Sol1_56_MergeRange.sort(intervals);
        Sol1_56_MergeRange sol = new Sol1_56_MergeRange();
        int[][] r = sol.merge(intervals);
        System.out.println(r);
    }
}
class Sol1_56_MergeRange {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        /**
         * 比下面的sort静态方法快
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int[] i : intervals) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(i[0]);
            l.add(i[1]);
            list.add(l);
        }
        for (int i = list.size() - 1; i >= 1; i --) {
            List<Integer> l1 = list.get(i);
            List<Integer> l0 = list.get(i - 1);
            if (l1.get(0) <= l0.get(1) && l1.get(0) > l0.get(0)) {
                list.remove(i);
                l0.set(1, l1.get(1));
            } else if (l1.get(0) <= l0.get(0)) {
                list.remove(i - 1);
            }
        }
        int[][] result = new int[list.size()][2];
        int i = 0;
        for (List<Integer> l : list) {
            result[i][0] = l.get(0);
            result[i][1] = l.get(1);
            i++;
        }
        return result;
    }

    public static void sort (int[][] intervals) {
        for (int i = intervals.length; i >= 0; i--) {
            for (int j = 0; j < i - 1; j ++) {
                if (intervals[j][1] > intervals[j + 1][1]) {
                    int temp0 = intervals[j][0];
                    int temp1 = intervals[j][1];
                    intervals[j][0] = intervals[j + 1][0];
                    intervals[j][1] = intervals[j + 1][1];
                    intervals[j + 1][0] = temp0;
                    intervals[j + 1][1] = temp1;
                }
            }
        }
    }
}