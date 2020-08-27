package cn.neyzoter.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 测试排序算法稳定性
 * @author neyzoter
 */
public class TestSort {
    public static void main(String[] args) {
        int[][] val = {{1, 1},{1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3},{3, 1}, {1, 4}, {1, 5}};
        /**
         * 稳定
         * Arrays.sort(int[], Comparator)稳定
         */
        Arrays.sort(val, (o1, o2) -> o1[0] - o2[0]);
        for (int[] v :val) {
            System.out.print(Arrays.toString(v) + " ");
        }


        /**
         * 不稳定
         * Arrays.sort(int[])
         */
        Arrays.sort(new int[]{1, 4, 6, 2});

        /**
         * 稳定
         */
        Collections.sort(new ArrayList<Integer>());
    }
}
