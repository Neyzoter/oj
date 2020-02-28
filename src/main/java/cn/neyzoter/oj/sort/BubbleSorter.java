package cn.neyzoter.oj.sort;

/**
 * 冒泡排序
 * @author Neyzoter Song
 * @date 2020-2-28
 */
public class BubbleSorter {

    /**
     * 冒泡排序
     * @param array array
     */
    public static void BubbleSort (int[] array) {
        for (int i = 0; i < array.length ; i ++) {
            for (int j = array.length - 1; j >= i + 1; j --) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};
        System.out.print("Before  ");
        for (int i : array) {
            System.out.print(i + ",");
        }
        BubbleSort(array);
        System.out.print("\nAfter   ");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
