package cn.neyzoter.oj.sort;

/**
 * 二分查找排序
 * @author Neyzoter Song
 * @date 2020-2-29
 */
public class BinarySearchSorter {

    /**
     * 二分查找排序
     * @param array array
     */
    public static void binarySearchSort (int[] array) {
        for (int i = 1; i < array.length ; i ++) {
            int temp = array[i];
            int left = 0,right = i - 1,mid;
            for (; left <= right ; ) {
                mid = (left + right) / 2;
                if (array[mid] < temp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            for (int j = i - 1; j >= left; j --) {
                array[j + 1] = array[j];
            }
            array[left] = temp;
        }
    }
    public static void main(String[] args) {
        int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};
        System.out.print("Before  ");
        for (int i : array) {
            System.out.print(i + ",");
        }
        binarySearchSort(array);
        System.out.print("\nAfter   ");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
