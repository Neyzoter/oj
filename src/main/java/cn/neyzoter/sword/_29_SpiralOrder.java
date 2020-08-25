package cn.neyzoter.sword;

import java.util.Arrays;

/**
 * 顺时针打印
 * @author neyzoter
 */
public class _29_SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] result;
        Sol1_SpiralOrder sol = new Sol1_SpiralOrder();
        result = sol.spiralOrder(matrix);
//        sol.printCircle(matrix, 1, result, 0);
        System.out.println(Arrays.toString(result));
    }
}

class Sol1_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int rs = 0;
        for (int start = 0; row > 2 * start && col > 2 * start; start++) {
            rs = printCircle(matrix, start, result, rs);
//            System.out.println(rs);
        }
        return result;
    }

    /**
     * 打印一圈到result
     * @param matrix 矩阵
     * @param ms 开始的位置[ms, ms]
     * @param result 打印结果
     * @param rs result开始的下标
     * @return result结束的下标
     */
    public int printCircle(int[][] matrix, int ms, int[] result, int rs) {
        int row = matrix.length;
        int col = matrix[0].length;
        int endX = row - 1 - ms;
        int endY = col - 1 - ms;
        // 右
        for (int i = ms; i <= endY; i++) {
            result[rs] = matrix[ms][i];
            rs++;
        }
        // 下
        for (int i = ms + 1; i <= endX; i++) {
            result[rs] = matrix[i][endY];
            rs++;
        }
        // 左
        for (int i = endY - 1; i >= ms && endX != ms; i--) {
            result[rs] = matrix[endX][i];
            rs++;
        }
        // 上
        for (int i = endX - 1; i > ms && endY != ms; i--) {
            result[rs] = matrix[i][ms];
            rs++;
        }
        return rs;
    }
}
