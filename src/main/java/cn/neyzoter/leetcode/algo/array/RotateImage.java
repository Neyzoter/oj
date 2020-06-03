package cn.neyzoter.leetcode.algo.array;

/**
 * 48  旋转图片
 * @author Neyzoter Song
 * @date 2020-2-15
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        Solution1_RotateImage solution1_rotateImage = new Solution1_RotateImage();
        System.out.print(String.format("matrix1 : "));
        System.out.println(matrix1);
        System.out.print(String.format("matrix1 Rotated: "));
        solution1_rotateImage.rotate(matrix1);
        System.out.print(String.format("matrix2 : "));
        System.out.println(matrix2);
        System.out.print(String.format("matrix2 Rotated: "));
        solution1_rotateImage.rotate(matrix2);
    }
}

class Solution1_RotateImage {
    public void rotate(int[][] matrix) {
        for (int low = 0, up = matrix.length-1; low < up; low ++, up --) {
            // side length - 1
            int length = up - low;
            int[] temp = new int[length];
            for (int temp_idx = low + 1; temp_idx <= up ; temp_idx ++) {
                temp[temp_idx - low - 1] = matrix[low][temp_idx];
            }
            for (int i = 0; i < length ; i ++) {
                matrix[low][up - i] = matrix[low  + i][low];
                matrix[low  + i][low] = matrix[up][low + i];
                matrix[up][low + i] = matrix[up - i][up];
                matrix[up - i][up] = temp[length - 1 - i];
            }
        }

    }
}
