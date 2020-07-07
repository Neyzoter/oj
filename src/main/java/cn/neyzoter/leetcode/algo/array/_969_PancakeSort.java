package cn.neyzoter.leetcode.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. 煎饼排序
 * @author Charles Song
 * @date 2020-7-7
 */
public class _969_PancakeSort {
    public static void main(String[] args) {

    }
}

/**
 * 递归<br>
 * 每次都翻转2次，使得最大的到最下面
 */
class Sol1_969_PancakeSort {
    public List<Integer> pancakeSort(int[] A) {
        return pancakeSort(A, A.length);
    }

    /**
     * 排序
     * @param A 数组
     * @param n 前n个
     * @return
     */
    public List<Integer> pancakeSort(int[] A, int n) {
        List<Integer> list = new ArrayList<>();
        if (n <= 1) {
            return list;
        }
        int maxValIdx = 0;
        // 找到最大值
        for (int i = 1; i < n; i ++) {
            if (A[i] > A[maxValIdx]) {
                maxValIdx = i;
            }
        }
        // 翻转
        convert(A, maxValIdx + 1);
        convert(A, n);
        list.add(maxValIdx + 1);
        list.add(n);
        List<Integer> sublist = pancakeSort(A, n - 1);
        list.addAll(sublist);
        return list;
    }

    /**
     * 翻转
     * @param A 数组
     * @param n 前n个
     */
    public static void convert(int[] A, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left ++;
            right --;
        }
    }
}