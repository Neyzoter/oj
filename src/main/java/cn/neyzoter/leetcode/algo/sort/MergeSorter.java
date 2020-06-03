package cn.neyzoter.leetcode.algo.sort;

/**
 * Merge Sorter<br></>
 * 归并排序
 * @author Neyzoter Song
 * @date 2020-3-1
 */
public class MergeSorter {

    public static int[] mergeSort (int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length/2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for (int i = 0 ; i < array.length ; i ++) {
            if (i < mid) {
                left[i] = array[i];
            } else {
                right[i - mid] = array[i];
            }
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * merge two sorted arrays
     * @param array_in1 sorted array
     * @param array_in2 sorted array
     * @return int[]
     */
    public static int[] merge (int[] array_in1, int[] array_in2) {
        if (array_in1.length == 0) {
            return array_in2;
        }
        if (array_in2.length == 0) {
            return array_in1;
        }
        int[] result = new int[array_in1.length + array_in2.length];
        int[] array1, array2;
        if (array_in1[0] < array_in2[0]) {
            array1 = array_in1;
            array2 = array_in2;
        } else {
            array2 = array_in1;
            array1 = array_in2;
        }

        int i1 = 0,i2 = 0, i3 = 0;
        for (; i2 < array1.length && i3 < array2.length ; i1 ++) {
            if (array1[i2] < array2[i3]) {
                result[i1] = array1[i2];
                i2 ++;
            } else {
                result[i1] = array2[i3];
                i3 ++;
            }
        }
        if (i2 < array1.length) {
            for (;i1 < result.length;i1 ++, i2 ++) {
                result[i1] = array1[i2];
            }
        } else {
            for (;i1 < result.length;i1 ++, i3 ++) {
                result[i1] = array2[i3];
            }
        }
        return result;
    }
    public static void main (String[] args) {
        int[] array = {0,3,2,1,9,8,7,6,10,5,4};
        System.out.print("Before  ");
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.print("\n");
        array = mergeSort(array);
        System.out.print("\nAfter   ");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
