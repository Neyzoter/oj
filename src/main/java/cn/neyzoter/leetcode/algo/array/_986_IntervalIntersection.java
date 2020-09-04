package cn.neyzoter.leetcode.algo.array;

import java.util.ArrayList;
import java.util.List;

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
    /**
     * 区间交集方法1
     * @param A 按照第0个数字排序的二维数组
     * @param B 按照第0个数字排序的二维数组
     * @return 区间交集，如果无交集则返回长度为0的数组
     */
    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int l = Math.max(A[i][0], B[j][0]);
            int h = Math.min(A[i][1], B[j][1]);
            if (l <= h) {
                ans.add(new int[]{l, h});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    /**
     * 区间交集方法2
     * @param A 按照第0个数字排序的二维数组
     * @param B 按照第0个数字排序的二维数组
     * @return 区间交集，如果无交集则返回长度为0的数组
     */
    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        ArrayList<Integer[]> lists = new ArrayList<>();
        for (int aptr = 0, bptr = 0;aptr < A.length && bptr < B.length; ) {
            int[] arange = A[aptr];
            int[] brange = B[bptr];
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