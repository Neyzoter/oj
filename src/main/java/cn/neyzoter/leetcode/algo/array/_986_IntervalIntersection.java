package cn.neyzoter.leetcode.algo.array;

import java.util.ArrayList;

/**
 * 986. 区间列表的交集
 * @author Charles Song
 * @date 2020-7-8
 */
public class _986_IntervalIntersection {
    public static void main(String[] args) {
    }
}

class Sol1_986_IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<Integer[]> lists = new ArrayList<>();
        for (int aptr = 0, bptr = 0;aptr < A.length && bptr < B.length; ) {
            int[] arange = A[aptr];
            int[] brange = B[aptr];
            int left = Math.max(arange[0], brange[0]);
            int right = Math.min(arange[1], brange[1]);
            if (left <= right) {
                Integer[] range = new Integer[2];
                range[0] = left;
                range[1] = right;
                lists.add(range);
            }
            int max = Math.max(arange[1], brange[1]);
            if (max == arange[1]) {
                bptr ++;
            } else {
                aptr ++;
            }
        }
        int[][] ranges = new int[lists.size()][2];
        int i = 0;
        for (Integer[] range : lists) {
            ranges[i][0] = range[0];
            ranges[i][1] = range[1];
            i++;
        }
        return ranges;
    }
}