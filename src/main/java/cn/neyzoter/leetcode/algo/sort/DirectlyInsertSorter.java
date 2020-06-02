package cn.neyzoter.leetcode.algo.sort;

/**
 * 直接插入排序
 * @author Neyzoter Song
 * @date 2020-2-28
 */
public class DirectlyInsertSorter {
    /**
     * 简单插入排序
     * @param array array
     */
    public static void DirectlyInsertSort (int[] array) {
        for (int i = 1; i < array.length ; i ++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >=0 ; j --) {
                if (array[j] >= temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] array = {0,3,2,1,9,8,7,6,10,5,4};
        System.out.print("Before  ");
        for (int i : array) {
            System.out.print(i + ",");
        }
        DirectlyInsertSort(array);
        System.out.print("\nAfter   ");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
