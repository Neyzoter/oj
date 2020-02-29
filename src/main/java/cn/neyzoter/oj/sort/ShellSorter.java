package cn.neyzoter.oj.sort;

/**
 * 希尔排序
 * @author Neyzoter Song
 * @date 2020-2-28
 */
public class ShellSorter {
    /**
     * hill sort
     * @param array array
     */
    public static void shellSort (int[] array) {
        for (int gap = array.length / 2; gap > 0 ; gap /= 2) {
            for (int i = 0; i < gap ; i ++ ){
                for (int j = i + gap; j < array.length; j += gap) {
                    int temp = array[j];
                    int x = j - gap;
                    for (; x >= 0 ; x -= gap) {
                        if (array[x] > temp) {
                            array[x + gap] = array[x];
                        } else {
                            break;
                        }
                    }
                    array[x + gap] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {0,3,2,1,9,8,7,6,10,5,4};
        System.out.print("Before  ");
        for (int i : array) {
            System.out.print(i + ",");
        }
        hillSort(array);
        System.out.print("\nAfter   ");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
