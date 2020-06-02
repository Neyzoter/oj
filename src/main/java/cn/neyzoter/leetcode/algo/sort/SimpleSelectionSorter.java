package cn.neyzoter.leetcode.algo.sort;

/**
 * 简单选择排序
 * @author Neyzoter Song
 * @date 2020-2-28
 */
public class SimpleSelectionSorter {
    /**
     * 简单选择排序
     * @param array array
     */
    public static void SimpleSelectionSort (int[] array) {
        for (int i = 0; i < array.length; i ++) {
            int minidx = array.length - 1;
            for (int j = array.length - 2; j >= i; j --) {
                if (array[minidx] > array[j]) {
                    minidx = j;
                }
            }
            int temp = array[i];
            array[i] = array[minidx];
            array[minidx] = temp;

        }
    }
    public static void main(String[] args) {
        int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};
        System.out.print("Before  ");
        for (int i : array) {
            System.out.print(i + ",");
        }
        SimpleSelectionSort(array);
        System.out.print("\nAfter   ");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
