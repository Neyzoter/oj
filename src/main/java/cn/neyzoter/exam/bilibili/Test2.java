package cn.neyzoter.exam.bilibili;


import java.util.Arrays;
import java.util.Scanner;

/**
 * B站测试2
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        Test2 t = new Test2();
        int[] res = t.SpiralMatrix(matrix);
        System.out.println(Arrays.toString(res));
    }

    public int[] SpiralMatrix (int[][] matrix) {
        // write code here
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1;
        int t = 0;
        int len = matrix.length - 1;
        int x = 0;
        int[] res = new int[(right + 1) * (len + 1)];
        while(true) {
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > len) {
                break;
            }
            for (int i = t; i <= len; i++) {
                res[x++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[len][i];
            }
            if (t > --len) {
                break;
            }
            for (int i = len; i >= t; i--) {
                res[x++] = matrix[i][left];
            }
            if(++left > right) {
                break;
            }
        }
        return res;
    }
}
