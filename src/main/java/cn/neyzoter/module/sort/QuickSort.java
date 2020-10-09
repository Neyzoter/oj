package cn.neyzoter.module.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序
 * @author neyzoter
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSortNoR quickSortNoR = new QuickSortNoR();
        int[] arr = {1, 4, 2, 7, 6, 9, 3, 2};
        System.out.println(Arrays.toString(quickSortNoR.quickSort(arr)));
    }
    public static int partition(int[] array, int left, int right) {
        int base = (int) ((right - left) * Math.random()) + left;
        swap(array, base, left);
        int x = left + 1, y = left + 1;
        for (; y <= right;) {
            if (array[left] > array[y]) {
                swap(array, x, y);
                x++;
            }
            y++;
        }
        swap(array, left, x - 1);
        return x - 1;
    }
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

/**
 * 非递归快排
 */
class QuickSortNoR {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0); stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            int mid = QuickSort.partition(array, left, right);
            if (mid - 1 > left) {
                stack.push(left);
                stack.push(mid - 1);
            }
            if (mid + 1 < right) {
                stack.push(mid + 1);
                stack.push(right);
            }
        }
        return array;
    }
}
