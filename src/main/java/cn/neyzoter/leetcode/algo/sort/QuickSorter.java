package cn.neyzoter.leetcode.algo.sort;

/**
 * 快速排序<br/>
 * 通过分治法实现
 * @author Neyzoter Song
 * @date 2020-3-1
 */
public class QuickSorter {

    /**
     * 快速排序
     * @param array array
     * @param left start from
     * @param right end with
     * @return index of pivot
     */
    public static void quickSort (int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = left;
        int idx = left + 1;
        for (int i = idx; i <= right; i ++) {
            if (array[i] < array[pivot]) {
                swap(array, idx, i);
                idx ++;
            }
        }
        swap(array, pivot, idx - 1);
        pivot = idx - 1;
        quickSort(array,left, pivot - 1);
        quickSort(array,pivot + 1, right);
    }
    private static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main (String[] args) {
        int[] array = {0,3,2,1,9,8,7,6,10,5,4};
        System.out.print("Before  ");
        for (int i : array) {
            System.out.print(i + ",");
        }
        quickSort(array,0, array.length - 1);
        System.out.print("\nAfter   ");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
