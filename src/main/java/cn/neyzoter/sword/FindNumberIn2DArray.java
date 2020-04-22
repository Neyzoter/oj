package cn.neyzoter.sword;

/**
 * 面试题04 二维数组中的查找
 * @author Charles Song
 * @date 2020-4-22
 */
public class FindNumberIn2DArray {
    public static void main (String[] args) {
        int[][] matrix = {  {1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}};
        int target = 5;
        Solution1_FindNumberIn2DArray solution1_findNumberIn2DArray = new Solution1_FindNumberIn2DArray();
        System.out.println(solution1_findNumberIn2DArray.findNumberIn2DArray(matrix, target));

        Solution2_FindNumberIn2DArray solution2_findNumberIn2DArray = new Solution2_FindNumberIn2DArray();
        System.out.println(solution2_findNumberIn2DArray.findNumberIn2DArray(matrix, target));
    }


}

/**
 * 暴力法
 */
class Solution1_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length ; i ++) {
            for (int j = 0 ; j < matrix[0].length ; j ++) {
                if (matrix[i][j] == target) {
                    // 找到target
                    return true;
                } else if (matrix[i][j] > target) {
                    // 这一行结束
                    break;
                }
            }
        }
        return false;
    }
}

/**
 * 对角取点法
 */
class Solution2_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1 ; (i < matrix.length) && (j >= 0);) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i ++;
            } else if (matrix[i][j] > target){
                j --;
            }
        }
        return false;
    }
}