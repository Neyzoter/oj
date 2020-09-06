package cn.neyzoter.exam.bilibili;


import java.util.Scanner;

/**
 * B站测试1
 * leetcode 1004 最大连续1的个数III
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int res = 0, i = 0, j = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (k > 0) {
                    k--;
                } else {
                    res = Math.max(res, i - j);
                    while (arr[j++] == 1);
                }
            }
        }
        return Math.max(res, i - j);
    }
}
